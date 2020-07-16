package com.portfolio.covidMapApp.model.poland;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PolandCovidResponse {

    @JsonProperty("features")
    private List<PolandCovidAttributes> features;

    //private String objectIdFieldName;

    public PolandCovidResponse() {
    }

    @Override
    public String toString() {
        return "PolandCovidResponse{" +
                "features=" + features +
                '}';
    }
//    public String getObjectIdFieldName() {
//        return objectIdFieldName;
//    }

//    public void setObjectIdFieldName(String objectIdFieldName) {
//        this.objectIdFieldName = objectIdFieldName;
//    }

    public List<PolandCovidAttributes> getFeatures() {
        return features;
    }

    public void setFeatures(List<PolandCovidAttributes> features) {
        this.features = features;
    }

    public static class PolandCovidAttributes {

        public PolandCovidAttributes() {
        }

        @JsonProperty(value = "attributes")
        private PolandCovidData polandCovidData;

        public PolandCovidData getPolandCovidData() {
            return polandCovidData;
        }

        public void setPolandCovidData(PolandCovidData polandCovidData) {
            this.polandCovidData = polandCovidData;
        }

        @Override
        public String toString() {
            return "PolandCovidAttributes{" +
                    "polandCovidData=" + polandCovidData +
                    '}';
        }
    }
}
