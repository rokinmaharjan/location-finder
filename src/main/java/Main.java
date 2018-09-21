import java.io.IOException;
import java.net.InetAddress;

import com.maxmind.geoip2.WebServiceClient;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CountryResponse;
import com.maxmind.geoip2.record.Country;

public class Main {
	public static void main(String[] args) throws IOException, GeoIp2Exception {
		
		// Replace 123 with account id
		// Replace licence_key with licence key from https://www.maxmind.com
		try (WebServiceClient client = new WebServiceClient.Builder(123, "licence_key").build()) {
			InetAddress ipAddress = InetAddress.getByName("202.166.207.34");

			CountryResponse response = client.country(ipAddress);

			Country country = response.getCountry();
			System.out.println(country.getIsoCode());
			System.out.println(country.getName());
		}
	}
}
