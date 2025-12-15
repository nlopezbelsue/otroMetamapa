package proxy.demo.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Getter
@Setter
@NoArgsConstructor
public class Ubicacion {
    private Double latitud;
    private Double longitud;
    private String pais;
    private String provincia;
    private String ciudad;

    public Ubicacion(Double latitud, Double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
//        this.completarDatos();
    }

    private JSONObject getAddressJSON() throws Exception {
        String urlStr = String.format(
                java.util.Locale.US,
                "https://nominatim.openstreetmap.org/reverse?format=json&lat=%f&lon=%f&zoom=10&addressdetails=1&accept-language=es",
                this.latitud, this.longitud
        );

        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("User-Agent", "Mozilla/5.0");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder respuesta = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            respuesta.append(inputLine);
        }
        in.close();

        JSONObject json = new JSONObject(respuesta.toString());
        return json.getJSONObject("address");
    }

    public void completarDatos() {
        try {
            JSONObject address = getAddressJSON();
            this.pais = address.has("country") ? address.getString("country") : "No encontrado";

            if (address.has("state")) {
                this.provincia = address.getString("state");
            } else if (address.has("region")) {
                this.provincia = address.getString("region");
            } else {
                this.provincia = "No encontrada";
            }

            if (address.has("city")) {
                this.ciudad = address.getString("city");
            } else if (address.has("town")) {
                this.ciudad = address.getString("town");
            } else if (address.has("village")) {
                this.ciudad = address.getString("village");
            } else if (address.has("municipality")) {
                this.ciudad = address.getString("municipality");
            } else {
                this.ciudad = "No encontrada";
            }

        } catch (Exception e) {
            e.printStackTrace();
            this.pais = "No encontrado";
            this.provincia = "No encontrada";
            this.ciudad = "No encontrada";
        }
    }


    @Override
    public String toString() {
        return "Ubicacion{" +
                "latitud=" + latitud +
                ", longitud=" + longitud +
                ", pais='" + pais + '\'' +
                ", provincia='" + provincia + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
