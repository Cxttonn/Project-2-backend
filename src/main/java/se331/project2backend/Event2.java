package se331.project2backend;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "events")
public class Event2 {
    @Id
    private String id;

    private String name;

    @JsonProperty("flag_url")
    private String flagUrl;

    @JsonProperty("total_medals")
    private int totalMedals;

    @JsonProperty("gold_medals")
    private int goldMedals;

    @JsonProperty("silver_medals")
    private int silverMedals;

    @JsonProperty("bronze_medals")
    private int bronzeMedals;

    @Embedded
    @JsonProperty("medals_by_sport")
    private MedalsBySport medalsBySport;

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

    public int getGoldMedals() {
        return goldMedals;
    }

    public void setGoldMedals(int goldMedals) {
        this.goldMedals = goldMedals;
    }

    public int getSilverMedals() {
        return silverMedals;
    }

    public void setSilverMedals(int silverMedals) {
        this.silverMedals = silverMedals;
    }

    public int getBronzeMedals() {
        return bronzeMedals;
    }

    public void setBronzeMedals(int bronzeMedals) {
        this.bronzeMedals = bronzeMedals;
    }

    public MedalsBySport getMedalsBySport() {
        return medalsBySport;
    }

    public void setMedalsBySport(MedalsBySport medalsBySport) {
        this.medalsBySport = medalsBySport;
    }


    @Embeddable
    public static class MedalsBySport {
        @Embedded
        @JsonProperty("until_2024")
        private Until2024 until2024;

        public Until2024 getUntil2024() {
            return until2024;
        }

        public void setUntil2024(Until2024 until2024) {
            this.until2024 = until2024;
        }
    }


    @Embeddable
    public static class Until2024 {
        @ElementCollection
        private List<Sport> sports;

        @Embedded
        private MedalTotals total;

        public List<Sport> getSports() {
            return sports;
        }

        public void setSports(List<Sport> sports) {
            this.sports = sports;
        }

        public MedalTotals getTotal() {
            return total;
        }

        public void setTotal(MedalTotals total) {
            this.total = total;
        }
    }


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


    @Embeddable
    public static class Sport {
        private String name;
        private int gold;
        private int silver;
        private int bronze;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

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
}
