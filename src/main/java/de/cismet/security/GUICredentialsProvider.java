/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
/*
 * GuiCredentialProvider.java
 *
 * Created on 18. Oktober 2006, 11:18
 *
 * To change this template, choose Tools | Template Manager and open the template in the editor.
 */
package de.cismet.security;

import de.cismet.tools.gui.StaticSwingTools;

import java.awt.Component;

import java.io.IOException;

import java.net.URL;

import java.util.prefs.Preferences;

import javax.swing.JFrame;

import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScheme;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.auth.CredentialsNotAvailableException;
import org.apache.commons.httpclient.auth.CredentialsProvider;
import org.apache.commons.httpclient.auth.NTLMScheme;
import org.apache.commons.httpclient.auth.RFC2617Scheme;
import org.apache.commons.httpclient.methods.GetMethod;

import org.jdesktop.swingx.JXLoginPane;
import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.auth.DefaultUserNameStore;
import org.jdesktop.swingx.auth.LoginService;


/**
 * DOCUMENT ME!
 *
 * @author   Sebastian
 * @version  $Revision$, $Date$
 */
public class GUICredentialsProvider extends LoginService implements CredentialsProvider {
    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(
            "de.cismet.cismap.commons.rasterservice.GUICredentialsProvider");

    private DefaultUserNameStore usernames;
    private Preferences appPrefs = null;
    private UsernamePasswordCredentials creds;
    private Component parent;
    private JFrame parentFrame;
    private boolean isAuthenticationDone = false;
    private boolean isAuthenticationCanceled = false;
    private URL url;
    private Object dummy = new Object();
    private String username = null;
    private String title;
    private String prefTitle;

    /**
     * Creates a new GUICredentialsProvider object.
     *
     * @param  url  DOCUMENT ME!
     */
    public GUICredentialsProvider(URL url) {
        super();
        log.debug("Creating new Credential Provider Instance for URL: " + url.toString());
        this.url = url;
    }

    /**
     * Creates a new GUICredentialsProvider object.
     *
     * @param  url              DOCUMENT ME!
     * @param  parentComponent  DOCUMENT ME!
     */
    public GUICredentialsProvider(URL url, Component parentComponent) {
        this(url);

        if (parentComponent != null) {
            this.parent = (StaticSwingTools.getParentFrame(parentComponent));

            if (this.parent == null) {
                this.parent = (StaticSwingTools.getFirstParentFrame(parentComponent));
            }
        }

    }

    /**
     * DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    public String getUserName() {
        return creds.getUserName();
    }

    /**
     * DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    public UsernamePasswordCredentials getCredentials() {
        return creds;
    }

    /**
     * DOCUMENT ME!
     *
     * @param  creds  DOCUMENT ME!
     */
    public void setUsernamePassword(UsernamePasswordCredentials creds) {
        this.creds = creds;
    }

    @Override public Credentials getCredentials(
        final AuthScheme authscheme,
        final String host,
        int port,
        boolean proxy) throws CredentialsNotAvailableException {
        log.debug("Credentials requested for :" + url.toString() + " alias: " + title);
        usernames = new DefaultUserNameStore();
        appPrefs = Preferences.userNodeForPackage(this.getClass());
        usernames.setPreferences(appPrefs.node("loginURLHash" + Integer.toString(url.toString().hashCode())));

        if (creds != null) {
            return creds;
        }

        synchronized (dummy) {

            if (creds != null) {
                return creds;
            }

            isAuthenticationCanceled = false;

            if (authscheme == null) {
                return null;
            }

            if (authscheme instanceof NTLMScheme) {
                requestUsernamePassword();

                return creds;
            }
            else if (authscheme instanceof RFC2617Scheme) {
                requestUsernamePassword();

                return creds;
            }
            else {
                throw (new CredentialsNotAvailableException(
                        "Unsupported authentication scheme: " +
                        authscheme.getSchemeName()));
            }
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @throws  CredentialsNotAvailableException  DOCUMENT ME!
     */
    private void requestUsernamePassword() throws CredentialsNotAvailableException {

        try {
            JXLoginPane login = new JXLoginPane(this, null, usernames);

            String[] names = usernames.getUserNames();

            if (names.length != 0) {
                username = names[names.length - 1];
            }

            login.setUserName(username);
            title = WebAccessManager.getInstance().getServerAliasProperty(url.toString());

            if (title != null) {
                login.setMessage(
                    org.openide.util.NbBundle.getMessage(GUICredentialsProvider.class,
                        "GUICredentialProvider.HttpAuthentication.Messagetext_1") +
                    " \"" + title + "\" ");
            }
            else {
                title = url.toString();

                if (title.startsWith("http://") && (title.length() > 21)) {
                    title = title.substring(7, 21) + "...";
                }
                else if (title.length() > 14) {
                    title = title.substring(0, 14) + "...";
                }

                login.setMessage(org.openide.util.NbBundle.getMessage(GUICredentialsProvider.class,
                        "GUICredentialProvider.HttpAuthentication.Messagetext_1") +
                    "\n" +
                    " \"" + title + "\" ");
            }

            log.debug("parentFrame in GUICredentialprovider:" + parent);

            JXLoginPane.JXLoginDialog dialog = new JXLoginPane.JXLoginDialog((JFrame) parent, login);

            try {
                ((JXPanel) ((JXPanel) login.getComponent(1)).getComponent(1)).getComponent(3).requestFocus();
            }
            catch (Exception skip) {

            }

            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);

            if (!isAuthenticationDone) {
                isAuthenticationCanceled = true;
                throw (new CredentialsNotAvailableException());
            }
        }
        catch (RuntimeException rte) {
            log.error("Problem in GUICredProv", rte);
        }
    }

    @Override public boolean authenticate(String name, char[] password, String server) throws Exception {
        log.debug("Authentication with username: " + name);

        if (testConnection(new UsernamePasswordCredentials(name, new String(password)))) {
            log.debug("Credentials are valid for URL: " + url.toString());
            usernames.removeUserName(name);
            usernames.saveUserNames();
            usernames.addUserName(name);
            usernames.saveUserNames();
            isAuthenticationDone = true;
            setUsernamePassword(new UsernamePasswordCredentials(name, new String(password)));

            return true;
        }
        else {
            log.debug("Credentials are not valid for URL: " + url.toString());

            return false;
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    public boolean isAuthenticationCanceled() {
        return isAuthenticationCanceled;
    }

    /**
     * DOCUMENT ME!
     *
     * @param   creds  DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    public boolean testConnection(UsernamePasswordCredentials creds) {
        HttpClient client = new HttpClient();
        String proxySet = System.getProperty("proxySet");

        if ((proxySet != null) && proxySet.equals("true")) {
            log.debug("proxyIs Set");
            log.debug("ProxyHost:" + System.getProperty("http.proxyHost"));
            log.debug("ProxyPort:" + System.getProperty("http.proxyPort"));

            try {
                client.getHostConfiguration().setProxy(System.getProperty("http.proxyHost"),
                    Integer.parseInt(System.getProperty("http.proxyPort")));
            }
            catch (Exception e) {
                log.error("Problem while setting proxy", e);
            }
        }

        GetMethod method = new GetMethod(url.toString());
        client.getState().setCredentials(new AuthScope(url.getHost(), AuthScope.ANY_PORT, AuthScope.ANY_REALM), creds);
        method.setDoAuthentication(true);

        int statuscode = 0;

        try {
            statuscode = client.executeMethod(method);
        }
        catch (IOException ex) {
        }

        if (statuscode == HttpStatus.SC_OK) {
            method.releaseConnection();

            return true;
        }
        else {
            method.releaseConnection();
            usernames.removeUserName(creds.getUserName());

            return false;
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @param  title  DOCUMENT ME!
     */
    public void setTitle(String title) {
        this.title = title;
    }
}