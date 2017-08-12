![Algalon_Icon](./Algalon_Icon-100x100.jpg "Algalon")

| [Home](./README.md) | [How to Use](./HowToUse.md) |

# Purpose

Algalon is an Android/Java library with the purpose of making it easier to access the Battle.net API
and the data it exposes. Currently, I am adding support for the three games available at the time of
writing this (**WoW, D3, SC2**) with WoW being the first.

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

## TODO

- [ ] Finish adding support for WoW API Calls
    - [x] Add network calls to WoWRequest for AlgalonA
    - [ ] Add network calls to WoWRequest for AlgalonJ
    - [ ] Add data models for API responses for AlgalonA
    - [ ] Add data models for API responses for AlgalonJ
- [ ] Add support for SC2 API calls
    - [x] Add network calls to SC2Request for AlgalonA
    - [ ] Add network calls to SC2Request for AlgalonJ
    - [ ] Add data models for API responses for AlgalonA
    - [ ] Add data models for API responses for AlgalonJ
- [ ] Add support for D3 API calls
    - [x] Add network calls to D3Request for AlgalonA
    - [ ] Add network calls to D3Request for AlgalonJ
    - [ ] Add data models for API responses for AlgalonA
    - [ ] Add data models for API responses for AlgalonJ
- [ ] Add support for OAuth2

## Licensing

Algalon is shared under the [MIT License](https://choosealicense.com/licenses/mit/), which means the
only requirement for using the code or packaged artifacts is to attribute credit to the original
developers [Paranoid Devs](https://github.com/Paranoid-Devs).

Copyright (c) 2017 Alcha/ParanoidDevs

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.