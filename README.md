# Purpose

Algalon is an Android/Java library with the purpose of making it easier to access the Battle.net API
and the data it exposes. Currently, I am adding support for the three games available at the time of
writing this (**08/09/17 e.g. WoW, D3, SC2**) with WoW being the first.

The Android and Java flavors of Algalon function _exactly_ the same, with the only difference being
which packages are used for handling network connections. For example, the Android version uses an
AsyncTask for handling API calls in the background. This is the only difference, as both versions
use the same dependency for JSON object processing,
[com.google.code.gson](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.8.1),
which is the **only** external dependency used by the library.

## Sole Dependency (Gson)

As stated in the previous paragraph, the `com.google.code.gson` library is the sole dependency used
by the library and it is used to convert JSON data that is returned from the API requests dinto Java
objects. It is also used to convert the Java objects to their JSON form if the user desires.

## Examples of How to Use

To use the library, first instantiate an AlgalonClient as this will be used to execute GameRequests.
For example, if you wish to get the basic character profile for a user, you'd use something like so:

```Java
AlgalonClient algalon = AlgalonClient.newUSInstance("apikey");

algalon.executeRequest(WoWRequest.getCharacterProfile(WoWUSRealms.Alterac_Mountains, "Alcha"), new Callback() {
    @Override
    public void onTaskCompleted(JSONObject response) {
        WoWCharacter character = WoWCharacter.newInstanceFromJSON(response);
        Log.d(LOG_TAG, "onTaskCompleted: " + character.toString());
    }
});
```

If you want to retrieve _more_ information regarding a character, pass an Array of FieldNames to the
`WoWRequest.getCharacterProfileFields()` method.

```Java
WoWCharacterField.Name[] characterFields = new WoWCharacterField.Name[]{
        WoWCharacterField.Name.Achievements,
        WoWCharacterField.Name.Appearance,
        WoWCharacterField.Name.Guild
};

algalon.executeRequest(WoWRequest.getCharacterProfileFields(WoWUSRealms.Kiljaeden, "Ndevar", characterFields), new Callback() {
    @Override
    public void onTaskCompleted(JSONObject response) {
        Log.d(LOG_TAG, "onTaskCompleted: getCharacterProfileFields - " + response.toString());
    }
});
```

If you want to execute more then one request, create an Array of Requests and pass it to the
`executeRequests()` method:

```Java
WoWGuildField.Name[] guildFields = new WoWGuildField.Name[]{
        WoWGuildField.Name.News,
        WoWGuildField.Name.Members,
        WoWGuildField.Name.Achievements
};

WoWRequest[] requests = new WoWRequest[]{
        WoWRequest.getCharacterProfileFields(WoWUSRealms.Alterac_Mountains, 
                "Alcha", characterFields),
        WoWRequest.getGuildProfileFields(WoWUSRealms.The_Forgotten_Coast, 
                "Lords of the Night", guildFields)
};

algalon.executeRequests(requests, new Callback() {
    @Override
    public void onTaskCompleted(JSONObject response) {
        Log.d(LOG_TAG, "onTaskCompleted: executeRequests - " + response.toString());
    }
});
```