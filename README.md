Build awesome things with email! Contextio takes the pain out of syncing email data with your app so you can focus on what makes your product great.

Contextio-Android is an easy to use Android library for communicating with the Context.IO 2.0 API. It is built upon Scrible and provides convenient asynchronous block based methods for interacting with the API.

### Getting Started

* Sign up for Developer Account [Contextio](https://context.io)
* [Submit a request](http://support.context.io/hc/en-us/requests/new) for a 3-legged OAuth Token. This library only supports 3-legged tokens to ensure end-users of your application can only access their own account
* Download [Contextio-Android](https://github.com/rishijash/Contextio-Android) and check out the included iOS example app. It is also available as a CocoaPod to make it even easier to add to your project
* View the full [Context.IO API documentation](https://context.io/docs/2.0) to better familiarize yourself with the API

### How to Setup

* Download [Contextio-Android](https://github.com/rishijash/Contextio-Android) from Github
* Add Scirble Dependency in your App Gridle:
```
     compile 'org.scribe:scribe:1.3.5'
```
* Import ContextioAPI.java, ContextioResult.java, OAuthProvider.java to your project.

### Example Usage

```
//Initialize
  ContextioAPI cio = new ContextioAPI("your-consumer-key","your-consumer-secret");
  
//Get User's Messages
  JSONObject params = new JSONObject();
  params.put("limit","80");

  cio.getMessages("user-account-id", params, new ContextioResult<JSONArray>() {
    @Override
    public void onTaskComplete(JSONArray result) {
      //API Result
      Log.e("messages", result.toString());
    }
  });

```

### Acknowledgements

Thanks to [Scirbble](https://github.com/scribble) which is used for authenticated communication with the API server.

### Lisence

Contextio-Android is licensed under the GNU LESSER GENERAL PUBLIC LICENSE. See the LICENSE file for details.
