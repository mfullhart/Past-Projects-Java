import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
 * A phone number testing class.
 *
 * @author mfullhart20@georgefox.edu
 */
public class PhoneNumberTest
{
    private static final String AREA_CODE = "612";
    private static final String PREFIX = "612";
    private static final String LINE_NUMBER = "6120";

    /**
     * Tests for ctor area code.
     */
    @Test
    public void test_PhoneNumber_ctor_invalidAreaCode_lessThanThreeChars()
    {
        assertThrows(IllegalArgumentException.class, () ->
            new PhoneNumber("61", PREFIX, LINE_NUMBER));
    }

    @Test
    public void test_PhoneNumber_ctor_invalidAreaCode_moreThanThreeChars()
    {
        assertThrows(IllegalArgumentException.class, () ->
                new PhoneNumber("6120", PREFIX, LINE_NUMBER));
    }

    @Test
    public void test_PhoneNumber_ctor_invalidAreaCode_containsLetters()
    {
        assertThrows(IllegalArgumentException.class, () ->
                new PhoneNumber("ASD", PREFIX, LINE_NUMBER));
    }

    @Test
    public void test_PhoneNumber_ctor_invalidAreaCode_firstDigitZero()
    {
        assertThrows(IllegalArgumentException.class, () ->
                new PhoneNumber("012", PREFIX, LINE_NUMBER));
    }

    @Test
    public void test_PhoneNumber_ctor_invalidAreaCode_firstDigitOne()
    {
        assertThrows(IllegalArgumentException.class, () ->
                new PhoneNumber("112", PREFIX, LINE_NUMBER));
    }

    @Test
    public void test_PhoneNumber_ctor_invalidAreaCode_emptyString()
    {
        assertThrows(IllegalArgumentException.class, () ->
                new PhoneNumber("", PREFIX, LINE_NUMBER));
    }

    @Test
    public void test_PhoneNumber_ctor_invalidAreaCode_null()
    {
        assertThrows(IllegalArgumentException.class, () ->
                new PhoneNumber(null, PREFIX, LINE_NUMBER));
    }

    /**
     * Tests for ctor prefix.
     */
    @Test
    public void test_PhoneNumber_ctor_invalidPrefix_lessThanThreeChars()
    {
        assertThrows(IllegalArgumentException.class, () ->
                new PhoneNumber(AREA_CODE, "61", LINE_NUMBER));
    }

    @Test
    public void test_PhoneNumber_ctor_invalidPrefix_moreThanThreeChars()
    {
        assertThrows(IllegalArgumentException.class, () ->
                new PhoneNumber(AREA_CODE, "6120", LINE_NUMBER));
    }

    @Test
    public void test_PhoneNumber_ctor_invalidPrefix_containsLetters()
    {
        assertThrows(IllegalArgumentException.class, () ->
                new PhoneNumber(AREA_CODE, "ASD", LINE_NUMBER));
    }

    @Test
    public void test_PhoneNumber_ctor_invalidPrefix_firstDigitZero()
    {
        assertThrows(IllegalArgumentException.class, () ->
                new PhoneNumber(AREA_CODE, "061", LINE_NUMBER));
    }

    @Test
    public void test_PhoneNumber_ctor_invalidPrefix_firstDigitOne()
    {
        assertThrows(IllegalArgumentException.class, () ->
                new PhoneNumber(AREA_CODE, "161", LINE_NUMBER));
    }

    @Test
    public void test_PhoneNumber_ctor_invalidPrefix_emptyString()
    {
        assertThrows(IllegalArgumentException.class, () ->
                new PhoneNumber(AREA_CODE, "", LINE_NUMBER));
    }

    @Test
    public void test_PhoneNumber_ctor_invalidPrefix_null()
    {
        assertThrows(IllegalArgumentException.class, () ->
                new PhoneNumber(AREA_CODE, null, LINE_NUMBER));
    }

    /**
     * Tests for ctor line number.
     */
    @Test
    public void test_PhoneNumber_ctor_invalidLineNumber_lessThanFourChars()
    {
        assertThrows(IllegalArgumentException.class, () ->
                new PhoneNumber(AREA_CODE, PREFIX, "612"));
    }

    @Test
    public void test_PhoneNumber_ctor_invalidLineNumber_moreThanFourChars()
    {
        assertThrows(IllegalArgumentException.class, () ->
                new PhoneNumber(AREA_CODE, PREFIX, "61274"));
    }

    @Test
    public void test_PhoneNumber_ctor_invalidLineNumber_containsLetters()
    {
        assertThrows(IllegalArgumentException.class, () ->
                new PhoneNumber(AREA_CODE, PREFIX, "WASD"));
    }

    @Test
    public void test_PhoneNumber_ctor_invalidLineNumber_emptyString()
    {
        assertThrows(IllegalArgumentException.class, () ->
                new PhoneNumber(AREA_CODE, PREFIX, ""));
    }

    @Test
    public void test_PhoneNumber_ctor_invalidLineNumber_null()
    {
        assertThrows(IllegalArgumentException.class, () ->
                new PhoneNumber(AREA_CODE, PREFIX, null));
    }

    /**
     * Tests  for getters.
     */
    @Test
    public void test_PhoneNumber_getAreaCode()
    {
        PhoneNumber number = new PhoneNumber(AREA_CODE, PREFIX, LINE_NUMBER);
        assertEquals(AREA_CODE, number.getAreaCode());
    }

    @Test
    public void test_PhoneNumber_getPrefix()
    {
        PhoneNumber number = new PhoneNumber(AREA_CODE, PREFIX, LINE_NUMBER);
        assertEquals(PREFIX, number.getPrefix());
    }

    @Test
    public void test_PhoneNumber_getLineNumber()
    {
        PhoneNumber number = new PhoneNumber(AREA_CODE, PREFIX, LINE_NUMBER);
        assertEquals(LINE_NUMBER, number.getLineNumber());
    }

    @Test
    public void test_PhoneNumber_getDigits()
    {
        PhoneNumber number = new PhoneNumber(AREA_CODE, PREFIX, LINE_NUMBER);
        assertEquals("6126126120", number.getDigits());
    }

    /**
     * Test for toString.
     */
    @Test
    public void test_PhoneNumber_toString()
    {
        PhoneNumber number = new PhoneNumber(AREA_CODE, PREFIX, LINE_NUMBER);
        assertEquals("612-612-6120", number.toString());
    }

    /**
     * Tests for compareTo.
     */
    @Test
    public void test_PhoneNumber_compareTo_comparison()
    {
        PhoneNumber number = new PhoneNumber(AREA_CODE, PREFIX, LINE_NUMBER);
        PhoneNumber number2 = new PhoneNumber(AREA_CODE, PREFIX, LINE_NUMBER);

        assertEquals(0, number.compareTo(number2));
    }

    @Test
    public void test_PhoneNumber_compareTo_null()
    {
        PhoneNumber number = new PhoneNumber(AREA_CODE, PREFIX, LINE_NUMBER);

        assertThrows(IllegalArgumentException.class, () ->
                number.compareTo(null));
    }

    /**
     * Tests for isValidPhoneNumber method area code.
     */
    @Test
    public void test_isValidPhoneNumber_invalidAreaCode_lessThanThreeChars()
    {
        assertFalse(PhoneNumber.isValidPhoneNumber("61", PREFIX, LINE_NUMBER));
    }
    @Test
    public void test_isValidPhoneNumber_invalidAreaCode_moreThanThreeChars()
    {
        assertFalse(PhoneNumber.isValidPhoneNumber("6120", PREFIX, LINE_NUMBER));
    }
    @Test
    public void test_isValidPhoneNumber_invalidAreaCode_containsLetters()
    {
        assertFalse(PhoneNumber.isValidPhoneNumber("ASD", PREFIX, LINE_NUMBER));
    }
    @Test
    public void test_isValidPhoneNumber_invalidAreaCode_firstDigitZero()
    {
        assertFalse(PhoneNumber.isValidPhoneNumber("061", PREFIX, LINE_NUMBER));
    }

    @Test
    public void test_isValidPhoneNumber_invalidAreaCode_firstDigitOne()
    {
        assertFalse(PhoneNumber.isValidPhoneNumber("161", PREFIX, LINE_NUMBER));
    }

    @Test
    public void test_isValidPhoneNumber_invalidAreaCode_emptyString()
    {
        assertFalse(PhoneNumber.isValidPhoneNumber("", PREFIX, LINE_NUMBER));
    }

    @Test
    public void test_isValidPhoneNumber_invalidAreaCode_null()
    {
        assertThrows(IllegalArgumentException.class, () ->
                PhoneNumber.isValidPhoneNumber(null, "555", "1234"));
    }

    /**
     * Tests for isValidPhoneNumber method prefix.
     */
    @Test
    public void test_isValidPhoneNumber_invalidPrefix_lessThanThreeChars()
    {
        assertFalse(PhoneNumber.isValidPhoneNumber(AREA_CODE, "61", LINE_NUMBER));
    }

    @Test
    public void test_isValidPhoneNumber_invalidPrefix_moreThanThreeChars()
    {
        assertFalse(PhoneNumber.isValidPhoneNumber(AREA_CODE, "6120", LINE_NUMBER));
    }

    @Test
    public void test_isValidPhoneNumber_invalidPrefix_containsLetters()
    {
        assertFalse(PhoneNumber.isValidPhoneNumber(AREA_CODE, "ASD", LINE_NUMBER));
    }

    @Test
    public void test_isValidPhoneNumber_invalidPrefix_firstDigitZero()
    {
        assertFalse(PhoneNumber.isValidPhoneNumber(AREA_CODE, "061", LINE_NUMBER));
    }

    @Test
    public void test_isValidPhoneNumber_invalidPrefix_firstDigitOne()
    {
        assertFalse(PhoneNumber.isValidPhoneNumber(AREA_CODE, "161", LINE_NUMBER));
    }

    @Test
    public void test_isValidPhoneNumber_invalidPrefix_emptyString()
    {
        assertFalse(PhoneNumber.isValidPhoneNumber(AREA_CODE, "", LINE_NUMBER));
    }

    @Test
    public void test_isValidPhoneNumber_invalidPrefix_null()
    {
        assertThrows(IllegalArgumentException.class, () ->
                PhoneNumber.isValidPhoneNumber("612", null, "6120"));
    }

    /**
     * Tests for isValidPhoneNumber method line number.
     */
    @Test
    public void test_isValidPhoneNumber_invalidLineNumber_lessThanFourChars()
    {
        assertFalse(PhoneNumber.isValidPhoneNumber(AREA_CODE, PREFIX,"612"));
    }

    @Test
    public void test_isValidPhoneNumber_invalidLineNumber_moreThanFourChars()
    {
        assertFalse(PhoneNumber.isValidPhoneNumber(AREA_CODE, PREFIX,"61274"));
    }

    @Test
    public void test_isValidPhoneNumber_invalidLineNumber_containsLetters()
    {
        assertFalse(PhoneNumber.isValidPhoneNumber(AREA_CODE, PREFIX,"WASD"));
    }

    @Test
    public void test_isValidPhoneNumber_invalidLineNumber_emptyString()
    {
        assertFalse(PhoneNumber.isValidPhoneNumber(AREA_CODE, PREFIX,""));
    }

    @Test
    public void test_isValidPhoneNumber_invalidLineNumber_null()
    {
        assertThrows(IllegalArgumentException.class, () ->
                PhoneNumber.isValidPhoneNumber("612", "612", null));
    }

    @Test
    public void test_isValidPhoneNumber_allEmptyStrings()
    {
        assertFalse(PhoneNumber.isValidPhoneNumber("","",""));
    }

    /**
     * Tests for parsePhoneNumber method area code.
     */
    @Test
    public void test_parsePhoneNumber_invalidAreaCode_lessThanThreeChars()
    {
        assertThrows(IllegalArgumentException.class, () ->
                PhoneNumber.parsePhoneNumber("61" + PREFIX + LINE_NUMBER));
    }

    @Test
    public void test_parsePhoneNumber_invalidAreaCode_moreThanThreeChars()
    {
        assertThrows(IllegalArgumentException.class, () ->
                PhoneNumber.parsePhoneNumber("6120" + PREFIX + LINE_NUMBER));
    }

    @Test
    public void test_parsePhoneNumber_invalidAreaCode_containsLetters()
    {
        assertThrows(IllegalArgumentException.class, () ->
                PhoneNumber.parsePhoneNumber("ASD" + PREFIX + LINE_NUMBER));
    }

    @Test
    public void test_parsePhoneNumber_invalidAreaCode_firstDigitZero()
    {
        assertThrows(IllegalArgumentException.class, () ->
                PhoneNumber.parsePhoneNumber("061" + PREFIX + LINE_NUMBER));
    }

    @Test
    public void test_parsePhoneNumber_invalidAreaCode_firstDigitOne()
    {
        assertThrows(IllegalArgumentException.class, () ->
                PhoneNumber.parsePhoneNumber("161" + PREFIX + LINE_NUMBER));
    }

    @Test
    public void test_parsePhoneNumber_invalidAreaCode_emptyString()
    {
        assertThrows(IllegalArgumentException.class, () ->
                PhoneNumber.parsePhoneNumber("" + PREFIX + LINE_NUMBER));
    }

    @Test
    public void test_parsePhoneNumber_invalidAreaCode_null()
    {
        assertThrows(IllegalArgumentException.class, () ->
                PhoneNumber.parsePhoneNumber(null + PREFIX + LINE_NUMBER));
    }

    /**
     * Tests for parsePhoneNumber method prefix.
     */
    @Test
    public void test_parsePhoneNumber_invalidPrefix_lessThanThreeChars()
    {
        assertThrows(IllegalArgumentException.class, () ->
                PhoneNumber.parsePhoneNumber(AREA_CODE + "61" + LINE_NUMBER));
    }

    @Test
    public void test_parsePhoneNumber_invalidPrefix_moreThanThreeChars()
    {
        assertThrows(IllegalArgumentException.class, () ->
                PhoneNumber.parsePhoneNumber(AREA_CODE + "6120" + LINE_NUMBER));
    }

    @Test
    public void test_parsePhoneNumber_invalidPrefix_containsLetters()
    {
        assertThrows(IllegalArgumentException.class, () ->
                PhoneNumber.parsePhoneNumber(AREA_CODE + "ASD" + LINE_NUMBER));
    }

    @Test
    public void test_parsePhoneNumber_invalidPrefix_firstDigitZero()
    {
        assertThrows(IllegalArgumentException.class, () ->
                PhoneNumber.parsePhoneNumber(AREA_CODE + "061" + LINE_NUMBER));
    }

    @Test
    public void test_parsePhoneNumber_invalidPrefix_firstDigitOne()
    {
        assertThrows(IllegalArgumentException.class, () ->
                PhoneNumber.parsePhoneNumber(AREA_CODE + "161" + LINE_NUMBER));
    }

    @Test
    public void test_parsePhoneNumber_invalidPrefix_emptyString()
    {
        assertThrows(IllegalArgumentException.class, () ->
                PhoneNumber.parsePhoneNumber(AREA_CODE + "" + LINE_NUMBER));
    }

    @Test
    public void test_parsePhoneNumber_invalidPrefix_null()
    {
        assertThrows(IllegalArgumentException.class, () ->
                PhoneNumber.parsePhoneNumber(AREA_CODE + null + LINE_NUMBER));
    }

    /**
     * Tests for parsePhoneNumber method line number.
     */
    @Test
    public void test_parsePhoneNumber_invalidLineNumber_lessThanFourChars()
    {
        assertThrows(IllegalArgumentException.class, () ->
                PhoneNumber.parsePhoneNumber(AREA_CODE + PREFIX + "612"));
    }

    @Test
    public void test_parsePhoneNumber_invalidLineNumber_moreThanFourChars()
    {
        assertThrows(IllegalArgumentException.class, () ->
                PhoneNumber.parsePhoneNumber(AREA_CODE + PREFIX + "61274"));
    }

    @Test
    public void test_parsePhoneNumber_invalidLineNumber_containsLetters()
    {
        assertThrows(IllegalArgumentException.class, () ->
                PhoneNumber.parsePhoneNumber(AREA_CODE + PREFIX + "WASD"));
    }

    @Test
    public void test_parsePhoneNumber_invalidLineNumber_emptyString()
    {
        assertThrows(IllegalArgumentException.class, () ->
                PhoneNumber.parsePhoneNumber(AREA_CODE + PREFIX + ""));
    }

    @Test
    public void test_parsePhoneNumber_invalidLineNumber_null()
    {
        assertThrows(IllegalArgumentException.class, () ->
                PhoneNumber.parsePhoneNumber(AREA_CODE + PREFIX + null));
    }

    /**
     * Tests for formatting.
     */
    @Test
    public void test_parsePhoneNumber_invalidFormat_extraSection()
    {
        assertThrows(IllegalArgumentException.class, () ->
                PhoneNumber.parsePhoneNumber("612-612-612-6120"));
    }

    @Test
    public void test_parsePhoneNumber_invalidFormat_allEmptyStrings()
    {
        assertThrows(IllegalArgumentException.class, () ->
                PhoneNumber.parsePhoneNumber(""));
    }

    @Test
    public void test_parsePhoneNumber_invalidFormat_leadingWhiteSpace()
    {
        assertThrows(IllegalArgumentException.class, () ->
                PhoneNumber.parsePhoneNumber("   " + AREA_CODE + PREFIX + LINE_NUMBER));
    }

    @Test
    public void test_parsePhoneNumber_invalidFormat_trailingWhiteSpace()
    {
        assertThrows(IllegalArgumentException.class, () ->
                PhoneNumber.parsePhoneNumber(AREA_CODE + PREFIX + LINE_NUMBER + "   "));
    }

     @Test
    public void test_parsePhoneNumber_invalidFormat_containsSpaces()
     {
         assertThrows(IllegalArgumentException.class, () ->
                 PhoneNumber.parsePhoneNumber("612 612 6120"));
     }

    @Test
    public void test_parsePhoneNumber_invalidFormat_containsPeriods()
    {
        assertThrows(IllegalArgumentException.class, () ->
                PhoneNumber.parsePhoneNumber("612.612.6120"));
    }

    @Test
    public void test_parsePhoneNumber_invalidFormat_containsUnderscores()
    {
        assertThrows(IllegalArgumentException.class, () ->
                PhoneNumber.parsePhoneNumber("612_612_6120"));
    }

    @Test
    public void test_parsePhoneNumber_invalidFormat_containsAsterisks()
    {
        assertThrows(IllegalArgumentException.class, () ->
                PhoneNumber.parsePhoneNumber("612*612*6120"));
    }

    @Test
    public void test_parsePhoneNumber_invalidFormat_containsColons()
    {
        assertThrows(IllegalArgumentException.class, () ->
                PhoneNumber.parsePhoneNumber("612:612:6120"));
    }
}
