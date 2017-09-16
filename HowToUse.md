![Algalon_Icon](./Algalon_Icon-100x100.jpg "Algalon")

| [Home](./README.md) | [How to Use](./HowToUse.md) | [License](./LICENSE.md) |

# How to Use

To use the library, first instantiate an AlgalonClient as this will be used to execute GameRequests.
For example, if you wish to get the basic character profile for a user, you'd use something like so:

```java
AlgalonClient algalon = AlgalonClient.newUSInstance("apikey");

algalon.executeRequest(WoWCommunityRequest.getCharacterProfile(Realm.fromString("Alterac Mountains"), "Alcha"), new RequestCallback() {
    @Override
    public void onTaskCompleted(JsonObject response) {
        Character character = Character.newInstanceFromJson(response);
        Log.d(LOG_TAG, "onTaskCompleted: " + character.toString());
    }
});
```

If you want to retrieve _more_ information regarding a character, pass an Array of FieldNames to the
`WoWRequest.getCharacterProfileFields()` method.

```java
CharacterField.Name[] fields = new CharacterField.Name[]{
        CharacterField.Name.Appearance,
        CharacterField.Name.Guild
};

WoWCommunityRequest request = WoWCommunityRequest.getCharacterProfileFields(
        Realm.fromString("Alterac Mountains"),
        "Alcha",
        fields
);

algalon.executeRequest(request, new RequestCallback() {
    @Override
    public void onTaskCompleted(JsonObject response) {
        Character character = Character.newInstanceFromJson(response);

        if (character.hasField(CharacterField.Name.Appearance))
            Log.d(LOG_TAG, "onTaskCompleted: " + character.getField(CharacterField.Name.Appearance));

        if (character.hasField(CharacterField.Name.Guild))
            Log.d(LOG_TAG, "onTaskCompleted: " + character.getField(CharacterField.Name.Guild));
    }
});
```

If you want to execute more then one request, create an Array of Requests and pass it to the
`executeRequests()` method:

```java
CharacterField.Name[] fields = new CharacterField.Name[]{
        CharacterField.Name.Appearance,
        CharacterField.Name.Guild
};

WoWCommunityRequest[] requests = new WoWCommunityRequest[]{
        WoWCommunityRequest.getCharacterProfileFields(
                Realm.fromString("Alterac Mountains"),
                "Alcha",
                fields
        ),
        WoWCommunityRequest.getAchievement(2144)
};

algalon.executeRequests(requests, new RequestCallback() {
    @Override
    public void onTaskCompleted(JsonObject response) {
        Log.d(LOG_TAG, "onTaskCompleted: " + response);
    }
});
```