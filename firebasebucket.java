package firebaseservice;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Bucket;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;

import java.io.FileInputStream;
import java.io.IOException;

public class firebasebucket {

       /* public static void main(String... args) throws Exception {
            // Instantiates a client
            Storage storage = StorageOptions.getDefaultInstance().getService();

            // The name for the new bucket
            String bucketName = args[0];  // "my-new-bucket";

            // Creates the new bucket
            Bucket bucket = storage.create(BucketInfo.of(bucketName));

            System.out.printf("Bucket %s created.%n", bucket.getName());
        }*/


    public firebasebucket() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("path/to/serviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setStorageBucket("<nsattu-69594>.appspot.com")
                .build();
        FirebaseApp.initializeApp(options);

        Bucket bucket = StorageClient.getInstance().bucket();
    }
}
