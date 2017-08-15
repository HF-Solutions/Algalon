![Algalon_Icon](./Algalon_Icon-100x100.jpg "Algalon")

| [Home](./README.md) | [How to Use](./HowToUse.md) | [License](./LICENSE.md) |

# How to Use

To use the library, first instantiate an AlgalonClient as this will be used to execute GameRequests.
For example, if you wish to get the basic character profile for a user, you'd use something like so:

```java
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

```java
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

```java
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