/**
 * A phone number class.
 *
 * @author mfullhart20@georgefox.edu
 */
public class PhoneNumber implements Comparable <PhoneNumber>
{
    private String _areaCode;
    private String _prefix;
    private String _lineNumber;

    /**
     * Constructs a phone number.
     *
     * @param areaCode The area code portion of a phone number.
     * @param prefix The prefix portion of a phone number.
     * @param lineNumber The line number portion of a phone number.
     */
    public PhoneNumber(String areaCode, String prefix, String lineNumber)
    {
        if (areaCode == null || prefix == null || lineNumber == null || !isValidPhoneNumber(areaCode, prefix, lineNumber))
        {
            throw new IllegalArgumentException("Invalid Phone Number");
        }

        _areaCode = areaCode;
        _prefix = prefix;
        _lineNumber = lineNumber;
    }

    /**
     * Gets the area code of the phone number.
     *
     * @return The area code.
     */
    public String getAreaCode()
    {
        return _areaCode;
    }

    /**
     * Gets the prefix of the phone number.
     *
     * @return The prefix.
     */
    public String getPrefix()
    {
        return _prefix;
    }

    /**
     * Gets the line number of the phone number.
     *
     * @return The line number.
     */
    public String getLineNumber()
    {
        return _lineNumber;
    }

    /**
     * Gets the digits of the phone number as a string.
     *
     * @return The digits as a string.
     */
    public String getDigits()
    {
        return String.format("%s%s%s", _areaCode, _prefix, _lineNumber);
    }

    /**
     * Returns a string representation of the phone number.
     *
     * @return The phone number.
     */
    @Override
    public String toString()
    {
        return String.format("%s-%s-%s", _areaCode, _prefix, _lineNumber);
    }

    /**
     * Compares this phone number with another phone number.
     *
     * @param other The other phone number to compare with.
     * @return A negative integer, zero, or a positive integer as this phone number
     * is less than, equal to, or greater than the specified phone number.
     */
    public int compareTo(PhoneNumber other)
    {
        if (other == null)
        {
            throw new IllegalArgumentException();
        }

        int compareAreaCode = this._areaCode.compareTo(other.getAreaCode());
        if (compareAreaCode != 0)
        {
            return compareAreaCode;
        }

        int comparePrefix = this._prefix.compareTo(other.getPrefix());
        if (comparePrefix != 0)
        {
            return comparePrefix;
        }

        return this._lineNumber.compareTo(other.getLineNumber());
    }

    /**
     * Validates the phone number based on the NANP format rules.
     *
     * @param areaCode   The area code portion of the phone number.
     * @param prefix     The prefix portion of the phone number.
     * @param lineNumber The line number portion of the phone number.
     * @return True if the phone number is valid, false otherwise.
     */
    public static boolean isValidPhoneNumber(String areaCode, String prefix, String lineNumber)
    {
        if (areaCode == null || prefix == null || lineNumber == null)
        {
            throw new IllegalArgumentException("Invalid Phone Number");
        }

        return areaCode.matches("[2-9][0-9]{2}")
                && prefix.matches("[2-9][0-9]{2}")
                && lineNumber.matches("[0-9]{4}");
    }

    /**
     * Parses a phone number from a string in the format XXX-XXX-XXXX.
     *
     * @param phoneNumber The phone number string to parse.
     * @return A new PhoneNumber object.
     * @throws IllegalArgumentException If the input string is not in the correct format.
     */
    public static PhoneNumber parsePhoneNumber(String phoneNumber)
    {
        String values = "[2-9][0-9]{2}-[2-9][0-9]{2}-[0-9]{4}";

        if (phoneNumber == null || !phoneNumber.matches(values))
        {
            throw new IllegalArgumentException();
        }

        String[] parts = phoneNumber.split("-");
        return new PhoneNumber(parts[0], parts[1], parts[2]);
    }
}