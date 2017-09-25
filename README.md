![Algalon_Icon](./Algalon_Icon-100x100.jpg "Algalon")

| [Home](./README.md) |

# Purpose

Algalon is a Java library with the purpose of making it easier to access the Battle.net API and
the data it exposes. Currently, I am adding support for the three games available at the time of
writing this (**WoW, D3, SC2**) with WoW being the first.

## Sole Dependency (Gson)

The `com.google.code.gson` library is the sole dependency and it is used to convert JSON data
that is returned from the API endpoints into Java objects. It is also used to convert the Java
objects to their JSON form if desired.

## TODO

- [x] Finish adding support for WoW API Calls
  - [x] Add network calls to WoWCommunityRequest
  - [x] Add data models for API WoWCommunityRequest
- [ ] Add Javadoc info for WoWCommunityRequest
- [ ] Add support for SC2 API calls
  - [ ] Add network calls to SC2Request
  - [ ] Add data models for API responses
- [ ] Add support for D3 API calls
  - [ ] Add network calls to D3Request
  - [ ] Add data models for API responses
- [ ] Add support for OAuth2

## Licensing

Algalon is shared under the [MIT License](https://choosealicense.com/licenses/mit/).