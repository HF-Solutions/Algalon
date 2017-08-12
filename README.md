![Algalon_Icon](./Algalon_Icon-100x100.jpg "Algalon")

| [Home](./README.md) | [How to Use](./HowToUse.md) | [Licensing](./LICENSE.md) |

# Purpose

Algalon is an Android/Java library with the purpose of making it easier to access the Battle.net API
and the data it exposes. Currently, I am adding support for the three games available at the time of
writing this (**WoW, D3, SC2**) with WoW being the first.

The Android and Java flavors of Algalon function _exactly_ the same, with the only difference being
which packages are used for handling network connections. For example, the Android version uses an
AsyncTask for handling API calls in the background and the Java flavor uses an ExecutorService. This
is the only difference, as both versions use the same dependency for JSON object processing,
[com.google.code.gson](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.8.1),
which is the **only** external dependency used by the library at this point (I don't plan to add
more in the future, but it _may_ become necessary).

## Sole Dependency (Gson)

As stated in the previous paragraph, the `com.google.code.gson` library is the sole dependency used
by the library and it is used to convert JSON data that is returned from the API requests dinto Java
objects. It is also used to convert the Java objects to their JSON form if the user desires.

## TODO

- [ ] Finish adding support for WoW API Calls
    - [x] Add network calls to WoWRequest for AlgalonA
    - [ ] Add network calls to WoWRequest for AlgalonJ
    - [ ] Add data models for API responses for AlgalonA
    - [ ] Add data models for API responses for AlgalonJ
- [ ] Add support for SC2 API calls
    - [ ] Add network calls to SC2Request for AlgalonA
    - [ ] Add network calls to SC2Request for AlgalonJ
    - [ ] Add data models for API responses for AlgalonA
    - [ ] Add data models for API responses for AlgalonJ
- [ ] Add support for D3 API calls
    - [ ] Add network calls to D3Request for AlgalonA
    - [ ] Add network calls to D3Request for AlgalonJ
    - [ ] Add data models for API responses for AlgalonA
    - [ ] Add data models for API responses for AlgalonJ
- [ ] Add support for OAuth2

## Licensing

Algalon is shared under the [MIT License](https://choosealicense.com/licenses/mit/), which means the
only requirement for using the code or packaged artifacts is to attribute credit to the original
developers [Paranoid Devs](https://paranoiddevs.com).

Full licensing information is available in [LICENSING.md](./LICENSE.md).