package firebaseservice;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import javax.xml.ws.ServiceMode;
import java.io.FileInputStream;
import java.io.IOException;

@ServiceMode
public class firbaseinitial {
    public void initiliaz() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream("path/to/serviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://nsattu-69594.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);

    }
}

