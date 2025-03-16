package com.dmf.mhbestiary.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

/**
 * @author David Martinez Flores
 */
@Data
public class Monster
{
    private String monster;

    @JsonProperty("elemental_weakness")
    private Object elementalWeakness;

    @JsonProperty("damage_type")
    private Object damageType;

    @JsonProperty("weak_spot")
    private String weakSpot;

    @JsonProperty("breakable_parts")
    private List<String> breakableParts;
    @Override
    public String toString() {
        return "<html>" +
                "🐉 <b>Monster:</b> " + monster + "<br>" +
                "🔥 <b>Elemental Weakness:</b> " + formatObject(elementalWeakness) + "<br>" +
                "⚔️ <b>Damage Type:</b> " + formatObject(damageType) + "<br>" +
                "🎯 <b>Weak Spot:</b> " + (weakSpot != null ? weakSpot : "None") + "<br>" +
                "🛠️ <b>Breakable Parts:</b> " + (breakableParts != null ? String.join(", ", breakableParts) : "None") +
                "</html>";
    }


    /**
     * Método auxiliar para formatear correctamente `elementalWeakness` y `damageType`,
     * ya que pueden ser Strings o Listas.
     */
    private String formatObject(Object obj) {
        if (obj instanceof List<?>) {
            // Convertimos a una lista de Strings usando stream()
            return ((List<?>) obj).stream()
                    .map(String::valueOf) // Convertimos cada elemento a String
                    .reduce((a, b) -> a + ", " + b) // Unimos con ", "
                    .orElse("None");
        }
        return obj != null ? obj.toString() : "None";
    }

}
