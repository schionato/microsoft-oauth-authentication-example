* It's necessary add the "microsoft_oauth_redirect_url" in the application manifest (https://apps.dev.microsoft.com)
* The communication need to be HTTPS
* How to generate key to HTTPS
- keytool -genkey -alias app -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore keystore.p12 -validity 3650