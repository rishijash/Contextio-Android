package com.rishi.contextio_library;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;
import java.util.Iterator;

/**
 * Created by rishi jash on 2/5/16.
 */

public class ContextioAPI extends AsyncTask<String, Integer, JSONArray>{

    private String consumerKey; //api key
    private String consumerSecret; //api secret

    private ContextioResult<JSONArray> callback;
    private String link;

    public ContextioAPI(String consumerKey, String consumerSecret)
    {
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;
    }

    public void getAccounts(JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/";
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("get");
    }

    public void postAccounts(JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/";
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("post");
    }

    public void getAccountsId(String account, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account;
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("get");
    }

    public void postAccountsId(String account, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account;
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("post");
    }

    public void deleteAccountsId(String account, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account;
        this.callback = callback;
        this.execute("delete");
    }

    public void getConnectTokens(String account, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/connect_tokens";
        this.callback = callback;
        this.execute("get");
    }

    public void postConnectTokens(String account, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/connect_tokens";
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("post");
    }

    public void getConnectTokensToken(String account, String token, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/connect_tokens/" + token;
        this.callback = callback;
        this.execute("get");
    }

    public void deleteConnectTokensToken(String account, String token, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/connect_tokens/" + token;
        this.callback = callback;
        this.execute("delete");
    }

    public void getContacts(String account, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/contacts";
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("get");
    }

    public void getContactsEmail(String account, String email, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/contacts/" + email;
        this.callback = callback;
        this.execute("get");
    }

    public void getContactsEmailFiles(String account, String email, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/contacts/" + email + "/files";
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("get");
    }

    public void getContactsEmailMessages(String account, String email, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/contacts/" + email + "/messages";
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("get");
    }

    public void getContactsEmailThreads(String account, String email, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/contacts/" + email + "/threads";
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("get");
    }

    public void getEmailaddresses (String account, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/email_address";
        this.callback = callback;
        this.execute("get");
    }

    public void postEmailaddresses (String account, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/email_address";
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("post");
    }

    public void getEmailaddressesEmail (String account, String email, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/email_address/" + email;
        this.callback = callback;
        this.execute("get");
    }

    public void postEmailaddressesEmail (String account, String email, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/email_address/" + email;
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("post");
    }

    public void deleteEmailaddressesEmail (String account, String email, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/email_address/" + email;
        this.callback = callback;
        this.execute("delete");
    }

    public void getFiles (String account, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/files";
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("get");
    }

    public void getFilesId (String account, String file_id, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/files/" + file_id;
        this.callback = callback;
        this.execute("get");
    }

    public void getFilesIdContent (String account, String file_id, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/files/" + file_id + "/content";
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("get");
    }

    public void getFilesIdRelated (String account, String file_id, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/files/" + file_id + "/related";
        this.callback = callback;
        this.execute("get");
    }

    public void getMessages(String account, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/messages";
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("get");
    }

    public void postMessages(String account, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/messages";
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("post");
    }

    public void getMessagesId(String account, String message_id, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/messages/" + message_id;
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("get");
    }

    public void postMessagesId(String account, String message_id, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/messages/" + message_id;
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("post");
    }

    public void deleteMessagesId(String account, String message_id, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/messages/" + message_id;
        this.callback = callback;
        this.execute("delete");
    }

    public void getMessagesIdBody(String account, String message_id, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/messages/" + message_id + "/body";
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("get");
    }

    public void getMessagesIdFlags(String account, String message_id, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/messages/" + message_id + "/flags";
        this.callback = callback;
        this.execute("get");
    }

    public void postMessagesIdFlags(String account, String message_id, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/messages/" + message_id + "/flags";
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("post");
    }

    public void getMessagesIdFolders(String account, String message_id, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/messages/" + message_id + "/folders";
        this.callback = callback;
        this.execute("get");
    }

    public void postMessagesIdFolders(String account, String message_id, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/messages/" + message_id + "/folders";
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("post");
    }

    public void putMessagesIdFolders(String account, String message_id, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/messages/" + message_id + "/folders";
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("put");
    }

    public void getMessagesIdHeaders(String account, String message_id, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/messages/" + message_id + "/headers";
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("get");
    }

    public void getMessagesIdSource(String account, String message_id, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/messages/" + message_id + "/source";
        this.callback = callback;
        this.execute("get");
    }

    public void getMessagesIdThread(String account, String message_id, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/messages/" + message_id + "/thread";
        this.callback = callback;
        this.execute("get");
    }

    public void getSources(String account, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/sources";
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("get");
    }

    public void postSources(String account, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/sources";
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("post");
    }

    public void getSourcesLabel(String account, String label, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/sources/" + label;
        this.callback = callback;
        this.execute("get");
    }

    public void postSourcesLabel(String account, String label, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/sources/" + label;
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("post");
    }

    public void deleteSourcesLabel(String account, String label, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/sources/" + label;
        this.callback = callback;
        this.execute("delete");
    }

    public void postSourcesLabelFolders(String account, String label, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/sources/" + label + "/folders";
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("post");
    }

    public void getSourcesLabelFoldersFolder(String account, String label, String folder, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/sources/" + label + "/folders/" + folder;
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("get");
    }

    public void deleteSourcesLabelFoldersFolder(String account, String label, String folder, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/sources/" + label + "/folders/" + folder;
        this.callback = callback;
        this.execute("delete");
    }

    public void putSourcesLabelFoldersFolder(String account, String label, String folder, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/sources/" + label + "/folders/" + folder;
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("put");
    }

    public void postSourcesLabelFoldersFolderExpunge(String account, String label, String folder, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/sources/" + label + "/folders/" + folder + "/expunge";
        this.callback = callback;
        this.execute("post");
    }

    public void getSourcesLabelFoldersFolderMessages(String account, String label, String folder, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/sources/" + label + "/folders/" + folder + "/messages";
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("get");
    }

    public void getSourcesLabelFoldersFolderMessagesAsync(String account, String label, String folder, String async_job_id, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/sources/" + label + "/folders/" + folder + "/messages/" + async_job_id;
        this.callback = callback;
        this.execute("get");
    }

    public void getSourcesLabelSync(String account, String label, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/sources/" + label + "/sync";
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("get");
    }

    public void postSourcesLabelSync(String account, String label, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/sources/" + label + "/sync";
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("post");
    }

    public void getSourcesLabelConnectTokens(String account, String label, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/sources/" + label + "/connect_tokens";
        this.callback = callback;
        this.execute("get");
    }

    public void postSourcesLabelConnectTokens(String account, String label, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/sources/" + label + "/connect_tokens";
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("post");
    }

    public void getSourcesLabelConnectTokensToken(String account, String label, String token, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/sources/" + label + "/connect_tokens/" + token;
        this.callback = callback;
        this.execute("get");
    }

    public void deleteSourcesLabelConnectTokensToken(String account, String label, String token, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/sources/" + label + "/connect_tokens/" + token;
        this.callback = callback;
        this.execute("delete");
    }

    public void getSync(String account, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/sync";
        this.callback = callback;
        this.execute("get");
    }

    public void postSync(String account, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/sync";
        this.callback = callback;
        this.execute("post");
    }

    public void getThreads(String account, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/threads";
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("get");
    }

    public void getThreadsId(String account, String thread_id, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/threads/" + thread_id;
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("get");
    }

    public void deleteThreadsId(String account, String thread_id, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/threads/" + thread_id;
        this.callback = callback;
        this.execute("delete");
    }

    public void postThreadsIdFolders(String account, String thread_id, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/threads/" + thread_id + "/folders";
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("post");
    }

    public void putThreadsIdFolders(String account, String thread_id, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/threads/" + thread_id + "/folders";
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("put");
    }

    public void getWebhooks(String account, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/webhooks";
        this.callback = callback;
        this.execute("get");
    }

    public void postWebhooks(String account, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/webhooks";
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("post");
    }

    public void getWebhooksWebhook(String account, String webhook_id, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/webhooks/" + webhook_id;
        this.callback = callback;
        this.execute("get");
    }

    public void postWebhooksWebhook(String account, String webhook_id, JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/webhooks/" + webhook_id;
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("post");
    }

    public void deleteWebhooksWebhook(String account, String webhook_id, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/" + account + "/webhooks/" + webhook_id;
        this.callback = callback;
        this.execute("delete");
    }

    public void getConnectTokens(ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/connect_tokens";
        this.callback = callback;
        this.execute("get");
    }

    public void postConnectTokens(JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/connect_tokens";
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("post");
    }

    public void getConnectTokensToken(String token, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/connect_tokens/" + token;
        this.callback = callback;
        this.execute("get");
    }

    public void deleteConnectTokensToken(String token, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/accounts/connect_tokens/" + token;
        this.callback = callback;
        this.execute("delete");
    }

    public void getDiscovery(JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/discovery";
        this.callback = callback;
        this.execute("get");
    }

    public void getOauthProviders(ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/oauth_providers";
        this.callback = callback;
        this.execute("get");
    }

    public void postOauthProviders(JSONObject params, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/oauth_providers";
        link = link + appendURL(params);
        this.callback = callback;
        this.execute("post");
    }

    public void getOauthProvidersProvider(String key, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/oauth_providers/" + key;
        this.callback = callback;
        this.execute("get");
    }

    public void deleteOauthProvidersProvider(String key, ContextioResult<JSONArray> callback)
    {
        link="https://api.context.io/2.0/oauth_providers/" + key;
        this.callback = callback;
        this.execute("delete");
    }

    public String appendURL(JSONObject params)
    {
        Uri.Builder builder = null;
        if(params!=null)
        {
            Iterator<String> iter = params.keys();
            builder = new Uri.Builder();
            while (iter.hasNext()) {
                String key = iter.next();
                try {
                    Object value = params.get(key);

                    //Encode Link
                    builder.appendQueryParameter(key, value.toString());

                } catch (JSONException e) {
                    // Something went wrong!
                }
            }
            return builder.build().toString();
        }
        return "";
    }

    @Override
    protected void onPostExecute(JSONArray jsonObject) {
        super.onPostExecute(jsonObject);
        callback.onTaskComplete(jsonObject);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected JSONArray doInBackground(String... params) {

        JSONArray responseobj=null;
        try{
            OAuthService service = new ServiceBuilder()
                    .provider(OAuthProvider.class)
                    .apiKey(consumerKey)
                    .apiSecret(consumerSecret)
                    .build();

            OAuthRequest request = null;

            if(params[0].equals("get"))
                request = new OAuthRequest(Verb.GET, link);
            else if(params[0].equals("post"))
                request = new OAuthRequest(Verb.POST, link);
            else if(params[0].equals("delete"))
                request = new OAuthRequest(Verb.DELETE, link);
            else if(params[0].equals("put"))
                request = new OAuthRequest(Verb.PUT, link);


            Token accessToken = new Token("", "");
            service.signRequest(accessToken, request);

            Response response = request.send();
            String b = response.getBody();
            Log.d("OAuthTask",response.getBody());
            try {
                responseobj = new JSONArray(response.getBody());
            } catch (JSONException e) {
                e.printStackTrace();
                responseobj = new JSONArray();
                responseobj.put(response.getBody());
            }
        }
        catch (Exception e)
        {
            Log.e("errror",e.toString());
        }
        return responseobj;
    }

}
