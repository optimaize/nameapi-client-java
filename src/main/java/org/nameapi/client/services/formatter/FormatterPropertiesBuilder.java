package org.nameapi.client.services.formatter;

/**
 * TODO write code, see server side classes.
 */
public class FormatterPropertiesBuilder {

    public FormatterProperties build() {
        return new FormatterPropertiesImpl("", "");
    }


    private static class FormatterPropertiesImpl implements FormatterProperties {
        private final String caseChoice;
        private final String nameOrderChoice;

        private FormatterPropertiesImpl(String caseChoice, String nameOrderChoice) {
            this.caseChoice = caseChoice;
            this.nameOrderChoice = nameOrderChoice;
        }

        @Override
        public String getCaseChoice() {
            return caseChoice;
        }
        @Override
        public String getNameOrderChoice() {
            return nameOrderChoice;
        }
    }

}
