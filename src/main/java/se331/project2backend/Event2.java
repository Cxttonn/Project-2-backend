package se331.project2backend;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Event2 {
    @Id
    private String id;

    private String name;
    private String continent;

    @JsonProperty("flag_url")
    private String flagUrl;

    @JsonProperty("total_medals")
    private int totalMedals;

    @Embedded
    @JsonProperty("medals_by_sport")
    private MedalsBySport medalsBySport;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getFlagUrl() {
        return flagUrl;
    }

    public void setFlagUrl(String flagUrl) {
        this.flagUrl = flagUrl;
    }

    public int getTotalMedals() {
        return totalMedals;
    }

    public void setTotalMedals(int totalMedals) {
        this.totalMedals = totalMedals;
    }

    public MedalsBySport getMedalsBySport() {
        return medalsBySport;
    }

    public void setMedalsBySport(MedalsBySport medalsBySport) {
        this.medalsBySport = medalsBySport;
    }

    // Inner class for medals by sport
    @Embeddable
    public static class MedalsBySport {
        private Until2024 until2024;

        public Until2024 getUntil2024() {
            return until2024;
        }

        public void setUntil2024(Until2024 until2024) {
            this.until2024 = until2024;
        }

        // Method to get totals
        public MedalTotals getTotal() {
            return (until2024 != null) ? until2024.getTotal() : null;
        }
    }

    // Inner class for medal totals
    @Embeddable
    public static class MedalTotals {
        private int gold;
        private int silver;
        private int bronze;

        public int getGold() {
            return gold;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }

        public int getSilver() {
            return silver;
        }

        public void setSilver(int silver) {
            this.silver = silver;
        }

        public int getBronze() {
            return bronze;
        }

        public void setBronze(int bronze) {
            this.bronze = bronze;
        }
    }

    // Inner class for until 2024
    @Embeddable
    public static class Until2024 {
        private MedalTotals total;

        public MedalTotals getTotal() {
            return total;
        }

        public void setTotal(MedalTotals total) {
            this.total = total;
        }
    }
}
