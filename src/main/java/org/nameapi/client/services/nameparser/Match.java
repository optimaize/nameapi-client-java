
package org.nameapi.client.services.nameparser;

import org.jetbrains.annotations.NotNull;

import java.util.List;


/**
 */
public class Match {

    private final int confidence;
    @NotNull
    private final String culture;
    private final int itemCount;
    @NotNull
    private final List<String> itemsAsStrings;
    private final int ruleChance;
    @NotNull
    private final String ruleName;


    public Match(int confidence, @NotNull String culture, int itemCount, @NotNull List<String> itemsAsStrings, int ruleChance, @NotNull String ruleName) {
        this.confidence = confidence;
        this.culture = culture;
        this.itemCount = itemCount;
        this.itemsAsStrings = itemsAsStrings;
        this.ruleChance = ruleChance;
        this.ruleName = ruleName;
    }



    public int getConfidence() {
        return confidence;
    }

    @NotNull
    public String getCulture() {
        return culture;
    }

    public int getItemCount() {
        return itemCount;
    }

    @NotNull
    public List<String> getItemsAsStrings() {
        return itemsAsStrings;
    }

    public int getRuleChance() {
        return ruleChance;
    }

    @NotNull
    public String getRuleName() {
        return ruleName;
    }



    @Override
    public String toString() {
        return "Match{" +
                "certainty=" + confidence +
                ", culture='" + culture + '\'' +
                ", itemCount=" + itemCount +
                ", itemsAsStrings=" + itemsAsStrings +
                ", ruleChance=" + ruleChance +
                ", ruleName='" + ruleName + '\'' +
                '}';
    }
}
