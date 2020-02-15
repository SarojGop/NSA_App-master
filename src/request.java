import com.uber.sdk.rides.client.model.Ride;
import com.uber.sdk.rides.client.model.RideRequestParameters;
import com.uber.sdk.rides.client.services.RidesService;

import java.io.IOException;

public class request {
    RideRequestParameters rideRequestParameters = new RideRequestParameters.Builder().setPickupCoordinates(37.77f, -122.41f)
            .setProductId("https://nsattu-69594.firebaseio.com")
            .setDropoffCoordinates(37.49f, -122.41f)
            .build();
    private RidesService service;
    Ride ride = service.requestRide(rideRequestParameters).execute().body();
        String rideId = ride.getRideId();


    public request () throws IOException {
    }
}
