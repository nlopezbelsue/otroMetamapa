package proxy.demo.services.impl;

import proxy.demo.Interfaces.DetectorDeSpam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetectorDeSpamImpl implements DetectorDeSpam {

    private static final List<String> PALABRAS_SPAM = List.of(
            "gana dinero", "dinero rápido", "gratis", "haz clic", "click aquí", "click aqui",
            "oferta exclusiva", "compra ahora", "crédito fácil", "ingreso extra",
            "promoción", "rebajas", "prueba gratis", "multiplica tu dinero",
            "felicitaciones ganaste", "premio", "ganador",
            "inversión segura", "sin requisitos", "cura milagrosa",
            "bajar de peso rápido", "visita mi sitio", "sigue este link", "viral", "100% real no fake"
    );

    @Override
    public boolean esSpam(String texto) {
        if (texto == null || texto.isBlank()) return true;

        String lower = texto.toLowerCase();

        long coincidencias = PALABRAS_SPAM.stream()
                .filter(lower::contains)
                .count();

        return coincidencias >= 2;
    }
}
