import org.apache.commons.cli.*;

public class Apache
{
    public static void main(String[] args)
    {
        // Parse args to get language and country first
        CommandLineParser initialParser = new DefaultParser();
        Options initialOptions = new Options();
        initialOptions.addOption("lang", "language", true, "Specify language option");
        initialOptions.addOption("ctry", "country", true, "Specify country of origin");

        initialOptions.addOption("h", "help", false, null);
        initialOptions.addOption("st", "shapeType", true, null);
        initialOptions.addOption("ra", "radius", true, null);
        initialOptions.addOption("si", "side", true, null);
        initialOptions.addOption("le", "length", true, null);
        initialOptions.addOption("wi", "width", true, null);
        initialOptions.addOption("ba", "base", true, null);
        initialOptions.addOption("he", "height", true, null);
        initialOptions.addOption("u", "units", true, null);
        initialOptions.addOption("m", "measure", true, null);

        CommandLine initialCmd = null;
        try
        {
            initialCmd = initialParser.parse(initialOptions, args);
        }
        catch (ParseException e)
        {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }

        String language = initialCmd.getOptionValue("lang", "en");
        String country = initialCmd.getOptionValue("ctry", "US");
        Internationalization i18n = new Internationalization(language, country);

        // Merge initial options and the main options
        Options options = new Options();
        // Add language and country options first
        options.addOption("lang", "language", true, i18n.getMessage("cli_option_language"));
        options.addOption("ctry", "country", true, i18n.getMessage("cli_option_country"));

        // Define options for the CLI with internationalized messages
        options.addOption("h", "help", false, i18n.getMessage("cli_option_help"));
        options.addOption("st", "shapeType", true, i18n.getMessage("cli_option_shapeType"));
        options.addOption("ra", "radius", true, i18n.getMessage("cli_option_radius"));
        options.addOption("si", "side", true, i18n.getMessage("cli_option_side"));
        options.addOption("le", "length", true, i18n.getMessage("cli_option_length"));
        options.addOption("wi", "width", true, i18n.getMessage("cli_option_width"));
        options.addOption("ba", "base", true, i18n.getMessage("cli_option_base"));
        options.addOption("he", "height", true, i18n.getMessage("cli_option_height"));
        options.addOption("u", "units", true, i18n.getMessage("cli_option_units"));
        options.addOption("m", "measure", true, i18n.getMessage("cli_option_measure"));

        // Create parser and parse the merged options list
        CommandLineParser parser = new DefaultParser();
        try
        {
            CommandLine cmd = parser.parse(options, args);

            // Use the options
            if (cmd.hasOption("h"))
            {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp(i18n.getMessage("cli_help_title"), options);
            }
            else
            {
                if (cmd.hasOption("st"))
                {
                    String shapeType = cmd.getOptionValue("st");
                    String measure = cmd.getOptionValue("m");

                    if (measure == null || (!measure.equals("area") && !measure.equals("perimeter")))
                    {
                        throw new IllegalArgumentException(i18n.getMessage("missing_measure"));
                    }

                    switch (shapeType)
                    {
                        case "circle":
                            System.out.println("Shape Type: " + shapeType);
                            if (cmd.hasOption("ra")) {
                                double radius = Double.parseDouble(cmd.getOptionValue("ra"));
                                Circle circle = new Circle(radius);
                                if (measure.equals("area"))
                                {
                                    System.out.printf(i18n.getMessage("area", shapeType, circle.calcArea()));
                                }
                                else
                                {
                                    System.out.printf(i18n.getMessage("perimeter", shapeType, circle.calcPerimeter()));
                                }
                            }
                            else
                            {
                                throw new IllegalArgumentException(i18n.getMessage("missing_radius"));
                            }
                            break;
                        case "square":
                            System.out.println("Shape Type: " + shapeType);
                            if (cmd.hasOption("si"))
                            {
                                double side = Double.parseDouble(cmd.getOptionValue("si"));
                                Square square = new Square(side);
                                if (measure.equals("area"))
                                {
                                    System.out.printf(i18n.getMessage("area", shapeType, square.calcArea()));
                                }
                                else
                                {
                                    System.out.printf(i18n.getMessage("perimeter", shapeType, square.calcPerimeter()));
                                }
                            }
                            else
                            {
                                throw new IllegalArgumentException(i18n.getMessage("missing_side"));
                            }
                            break;
                        case "rectangle":
                            System.out.println("Shape Type: " + shapeType);
                            if (cmd.hasOption("le") && cmd.hasOption("wi"))
                            {
                                double length = Double.parseDouble(cmd.getOptionValue("le"));
                                double width = Double.parseDouble(cmd.getOptionValue("wi"));
                                Rectangle rectangle = new Rectangle(length, width);
                                if (measure.equals("area"))
                                {
                                    System.out.printf(i18n.getMessage("area", shapeType, rectangle.calcArea()));
                                }
                                else
                                {
                                    System.out.printf(i18n.getMessage("perimeter", shapeType, rectangle.calcPerimeter()));
                                }
                            }
                            else
                            {
                                throw new IllegalArgumentException(i18n.getMessage("missing_length_or_width"));
                            }
                            break;
                        case "rightTriangle":
                            System.out.println("Shape Type: " + shapeType);
                            if (cmd.hasOption("ba") && cmd.hasOption("he"))
                            {
                                double base = Double.parseDouble(cmd.getOptionValue("ba"));
                                double height = Double.parseDouble(cmd.getOptionValue("he"));
                                RightTriangle rightTriangle = new RightTriangle(base, height);
                                if (measure.equals("area"))
                                {
                                    System.out.printf(i18n.getMessage("area", shapeType, rightTriangle.calcArea()));
                                }
                                else
                                {
                                    System.out.printf(i18n.getMessage("perimeter", shapeType, rightTriangle.calcPerimeter()));
                                }
                            }
                            else
                            {
                                throw new IllegalArgumentException(i18n.getMessage("missing_base_or_height"));
                            }
                            break;
                        default:
                            throw new IllegalArgumentException(i18n.getMessage("unsupported_shape", shapeType));
                    }
                }
                else
                {
                    throw new IllegalArgumentException(i18n.getMessage("missing_shape_type"));
                }
            }
        }
        catch (ParseException e)
        {
            System.err.println("Error: " + e.getMessage());
        }
        catch (IllegalArgumentException e)
        {
            System.err.println("IllegalArgumentException: " + e.getMessage());
        }
    }
}
