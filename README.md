# Purpose

Algalon is an Android/Java library with the purpose of making it easier to access the Battle.net API
and the data it exposes. Currently, I am adding support for the three games available at the time of
writing this (08/09/17 e.g. WoW, D3, SC2) with WoW being the first.

The Android and Java flavors of Algalon function _exactly_ the same, with the only difference being
which packages are used for handling network connections. For example, the Android version uses an
AsyncTask for handling API calls in the background. This is the only difference, as both versions
use the same dependency for JSON object processing
([com.google.code.gson]("https://mvnrepository.com/artifact/com.google.code.gson/gson/2.8.1")),
which is the **only** external dependency used by the library.

## Sole Dependency (Gson)

As stated in the previous paragraph, the `com.google.code.gson` library is the sole dependency used
by the library and it is used to convert JSON data that is returned from the API requests to Java
objects. It is also used to convert the Java objects to their JSON form if the user desires.