package firebaseservice;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;

import javax.xml.ws.ServiceMode;

@ServiceMode
public class firebaseService {
     String email;

    public firebaseService () throws FirebaseAuthException {
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    UserRecord userRecord = FirebaseAuth.getInstance().getUserByEmail(email);

}
