package example.Model;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.*;


@Service
public class FBInitialize {

    @PostConstruct
    public void initialize() {
        try {
            System.out.println("FireStore Boot has started");
            String initialString = "{\n" +
                    "  \"type\": \"service_account\",\n" +
                    "  \"project_id\": \"qr-database-a6078\",\n" +
                    "  \"private_key_id\": \"5dd2f2d0f1e93a31459165e0a991c7e72eb6a6ed\",\n" +
                    "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDWJcfgdok8yyry\\nZ6sGnH4L9n3XbyosJQ6hMV6ltT1XSl5dNA3Ue3AvvAr/6dDoyngA8p7wsOz/nZJS\\noKzuJoQLiECSSeQ5V/4M6Mvhd8RlBkyhyVPSiLjFYWiCzDDNvIYOXU7oqiFLRf+8\\nydlWmXGSP9ezrFVi96sIby8/j5miR0PA1lpJzfkVYq8mWCjOOxAw8zAYgM604aBb\\noJJQs4HgLYKKPmr6VH/sYpoQ46Oe9FctnzOAvaR3kXATISGCsC/Q7D+dxVh96Ees\\nu6xLVcjLuQ3zEYS/ecEW249W5HcyXZQ17L2jPeT1Lstw7qlh8J253VV0JCIdGV0q\\nXGvSp7qrAgMBAAECggEAJt9v03qg+eSldKBF5urUZKaHfGpk/ONzLuaP2EO4kVZi\\nH8gZtJb9q+SWGJNghUlvlDh2ipmLQ/FeBNq+2XIraQ6ALi30nEYxSzWdAN4lS/Nj\\nSMELkr2X0NiYSJn5R/dvXD8q2kg7x/a6cBIx/irXd2VYafif/VmY9ex85qxSBqdU\\nvqIV3ElU7nqeZ0jHTfn59La/gkwx9QXEM84ECpSbdCae/4ht/2xbEhB6Cq8w9Bio\\n1Y5kXdFHeNbUY3/YudNq4BOZaSyIuaxTOGiRpN3Q+IVSi+cIDqVM6iC7DsgSMeBK\\nru2u1Cwnms1/fd+nian2LU70Yyfphx8GxwCOBrGH9QKBgQD/MiSfugPXUFJ6eTaJ\\nGSRHO1JZHpWTwZT2J4wZ3YXCJ9htgrXaIEbiklxhbTPU81mo38LphpJGTJ9KCwO1\\nnpEhzuj4+eLgax9n2HIx+MrhgEskknr2ihZs+KTjw/FBdcGspVD5QgeE4wQAXgj4\\nfbwkxFoRpwb0x7mZbapdSHGsvQKBgQDW0oaNGE0y9OuaxmQCAto17WHT2CE3PpQi\\nmbALghwSA38SuT0F3/lazlrJ0v25ckv/lleYGOJx2CJxYkjzDD2CrEKpBNQg+1a1\\nOjzNUoWdA8lYGR8+oLH6n1AyzHpnMvwljmJWmqASAE3iYa+HnHt9B/OfKxHocJ2q\\nfqj5poHfhwKBgEHOqGsYCM2JRPuYLlwEQ7qqrX2VyXSkwskHQbWZzlhW9hSnVEW/\\ndQgQPgpRosATUNeffB/EOAwwzhLF7Fr1XO+e76zko4DDnwGkay4/vfGQp8/yhgr1\\naPsI01x4tsnul9bxeoQMZuv5rpp5pU6O/eltSNysebq9ljrecMRFXirxAoGADADr\\nf8rR1X0WBSn8wJgENWs0QjAbewjGIkDQM3RruR305cjv/foL5uUM8aYWg1w9nuR5\\ntIf/bzkSg59oUBxo+3pAp00bxVQF/k5ow1hPGvzxLTkKI+e6yjRIuO3wEQAqUrbo\\nC8rMEvVtZK7srfkydUQSetxfPcu9I5+8NWb2btUCgYEA1lhQeTu7M+N22PUYrbdZ\\n2esZi7CEPxBPGGXQdY8sGk0yWu2LfPXOBXyYn5krXnmhwWmIP4FWNZR2I0IgpaZh\\nLoRPyq9+TqN4SAkk7y6FGUoV6dFZmLJh9s8zzyxLNZ8rapWHHhIGG6F6iv9/S05t\\n0LYDGzRexhk8eDEGOccTbro=\\n-----END PRIVATE KEY-----\\n\",\n" +
                    "  \"client_email\": \"firebase-adminsdk-885ht@qr-database-a6078.iam.gserviceaccount.com\",\n" +
                    "  \"client_id\": \"112816667159467742421\",\n" +
                    "  \"auth_uri\": \"https://accounts.google.com/o/oauth2/auth\",\n" +
                    "  \"token_uri\": \"https://oauth2.googleapis.com/token\",\n" +
                    "  \"auth_provider_x509_cert_url\": \"https://www.googleapis.com/oauth2/v1/certs\",\n" +
                    "  \"client_x509_cert_url\": \"https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-885ht%40qr-database-a6078.iam.gserviceaccount.com\"\n" +
                    "}\n";
            InputStream targetStream = new ByteArrayInputStream(initialString.getBytes());
            GoogleCredentials googleCred = GoogleCredentials.fromStream(targetStream);
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(googleCred)
                    .setDatabaseUrl("https://qr-database-a6078.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}