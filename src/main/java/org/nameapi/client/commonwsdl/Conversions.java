package org.nameapi.client.commonwsdl;

import com.google.common.base.Optional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nameapi.client.commonwsdl.context.SoapContext;
import org.nameapi.client.commonwsdl.person.*;
import org.nameapi.ontology4.input.context.Context;
import org.nameapi.ontology4.input.entities.address.Address;
import org.nameapi.ontology4.input.entities.address.AddressRelation;
import org.nameapi.ontology4.input.entities.address.AddressUsage;
import org.nameapi.ontology4.input.entities.address.StreetInfo;
import org.nameapi.ontology4.input.entities.contact.EmailAddress;
import org.nameapi.ontology4.input.entities.contact.TelNumber;
import org.nameapi.ontology4.input.entities.person.InputPerson;
import org.nameapi.ontology4.input.entities.person.NaturalInputPerson;
import org.nameapi.ontology4.input.entities.person.age.AgeInfo;
import org.nameapi.ontology4.input.entities.person.name.InputPersonName;
import org.nameapi.ontology4.input.entities.person.name.NameField;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Provides methods for converting objects from and to generated Soapdl implementations.
 *
 * @author fab
 */
public class Conversions {

    @NotNull
    public static SoapContext convert(@NotNull Context context) {
        SoapContext ret = new SoapContext();
        ret.setApiKey(context.getApiKey());
        ret.setPriority(context.getPriority());
        ret.setGeo(context.getGeo().orNull());
        if (context.getTextCase().isPresent()) ret.setTextCase( context.getTextCase().get() );
        if (!context.getProperties().isEmpty()) {
            SoapContext.Properties properties = new SoapContext.Properties();
            for (Map.Entry<String, String> entry : context.getProperties().entrySet()) {
                SoapContext.Properties.Entry soapEntry = new SoapContext.Properties.Entry();
                soapEntry.setKey(entry.getKey());
                soapEntry.setValue(entry.getValue());
                properties.getEntry().add(soapEntry);
            }
            ret.setProperties(properties);
        }
        return ret;
    }


    @NotNull
    public static SoapSimpleNaturalPerson convert(@NotNull InputPerson person) {
        NaturalInputPerson natPerson = (NaturalInputPerson)person;
        SoapSimpleNaturalPerson ret = new SoapSimpleNaturalPerson();
        ret.setPersonName( convert(natPerson.getPersonName().orNull()) );
        ret.setGender(natPerson.getGender());
        //TODO ret.getTitles().addAll(natPerson.getTitles());
        ret.setMaritalStatus(natPerson.getMaritalStatus());
        ret.getNationalities().addAll(natPerson.getNationalities());
        ret.getNativeLanguages().addAll(natPerson.getNativeLanguages());
        ret.setCorrespondenceLanguage(natPerson.getCorrespondenceLanguage().orNull());
        ret.setReligion(natPerson.getReligion().orNull());

        if (!person.getAddresses().isEmpty()) {
            for (AddressRelation addressRelation : person.getAddresses()) {
                SoapAddressRelation soapAddressRelation = new SoapAddressRelation();
                soapAddressRelation.setUsageForAll( addressRelation.isUsageForAll() );
                Optional<Set<AddressUsage>> specificUsage = addressRelation.getSpecificUsage();
                if (specificUsage.isPresent()) {
                    for (AddressUsage addressUsage : specificUsage.get()) {
                        soapAddressRelation.getSpecificUsage().add(addressUsage);
                    }
                }
                soapAddressRelation.setAddress( convertAddress( addressRelation.getAddress() ) );
                ret.getAddresses().add( soapAddressRelation );
            }
        }

        if (person.getAgeInfo().isPresent()) {
            ret.setAgeInfo( convertAgeInfo(person.getAgeInfo().get()) );
        }

        for (EmailAddress emailAddress : natPerson.getEmailAddresses()) {
            SoapEmailAddress soapEmailAddress = new SoapEmailAddress();
            soapEmailAddress.setEmailAddress( emailAddress.getEmailAddress() );
            ret.getEmailAddresses().add(soapEmailAddress);
        }

        for (TelNumber telNumber : person.getTelNumbers()) {
            SoapTelNumber soapTelNumber = new SoapTelNumber();
            soapTelNumber.setFullNumber(telNumber.getFullNumber());
            ret.getTelNumbers().add(soapTelNumber);
        }

        return ret;
    }

    @NotNull
    private static SoapAddress convertAddress(@NotNull Address address) {
        SoapAddress soapAddress = new SoapAddress();
        soapAddress.setCountry(address.getCountry().orNull());
        soapAddress.setPlaceName(address.getPlaceName().orNull());
        soapAddress.setPobox(address.getPobox().orNull());
        soapAddress.setPostalCode(address.getPostalCode().orNull());
        soapAddress.setRegion(address.getRegion().orNull());
        if (address.getStreetInfo().isPresent()) {
            soapAddress.setStreetInfo(convertStreetInfo(address.getStreetInfo().get()));
        }
        return soapAddress;
    }

    @NotNull
    private static SoapStreetInfo convertStreetInfo(@NotNull StreetInfo streetInfo) {
        SoapStreetInfo soapStreetInfo = new SoapStreetInfo();
        soapStreetInfo.setStreetName(streetInfo.getStreetName().orNull());
        soapStreetInfo.setStreetNumber(streetInfo.getStreetNumber().orNull());
        soapStreetInfo.setStreetNameAndNumber(streetInfo.getStreetNameAndNumber().orNull());
        soapStreetInfo.setApartment(streetInfo.getApartment().orNull());
        soapStreetInfo.setBuilding(streetInfo.getBuilding().orNull());
        soapStreetInfo.setFloor(streetInfo.getFloor().orNull());
        soapStreetInfo.setStaircase(streetInfo.getStaircase().orNull());
        soapStreetInfo.setAsString(streetInfo.getAsString());
        soapStreetInfo.setAddressLine2(streetInfo.getAddressLine2().orNull());
        return soapStreetInfo;
    }

    @NotNull
    private static SoapAgeInfo convertAgeInfo(@NotNull AgeInfo ageInfo) {
        SoapAgeInfo soapAgeInfo = new SoapAgeInfo();
        soapAgeInfo.setBirthYear(ageInfo.getBirthYear().orNull());
        soapAgeInfo.setBirthMonth(ageInfo.getBirthMonth().orNull());
        soapAgeInfo.setBirthDay(ageInfo.getBirthDay().orNull());
        List<Integer> birthYearRange = soapAgeInfo.getBirthYearRange();
        if (ageInfo.getBirthYearRange().getStartIncluding().isPresent() && ageInfo.getBirthYearRange().getEndIncluding().isPresent()) {
            birthYearRange.add(ageInfo.getBirthYearRange().getStartIncluding().get());
            birthYearRange.add(ageInfo.getBirthYearRange().getEndIncluding().get());
        }
        return soapAgeInfo;
    }

    @Nullable
    public static SoapPersonName convert(@Nullable InputPersonName personName) {
        if (personName==null) {
            return null;
        } else { //if (personName instanceof FieldBasedPersonName) {
            SoapPersonName soapPersonName = new SoapPersonName();
            List<SoapNameField> names = soapPersonName.getNames();
            for (NameField nameField : personName.getNameFields()) {
                SoapNameField soapTerm = new SoapNameField();
                soapTerm.setString(nameField.getString());
                soapTerm.setFieldType(nameField.getFieldType().name());
                names.add(soapTerm);
            }
            return soapPersonName;
        }
    }

    @NotNull
    public static SoapNameField convert(@NotNull NameField nameField) {
        SoapNameField ret = new SoapNameField();
        ret.setFieldType( nameField.getFieldType().name() );
        ret.setString( nameField.getString() );
        return ret;
    }

}
