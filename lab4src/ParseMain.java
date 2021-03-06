import java.io.*;

//
// Main compiler driver program
//

public class ParseMain
{
	// Set these to produce various output. For code generation,
	// only set CODE_GEN_OUTPUT to true, everything else to false.
	public static boolean PARSE_OUTPUT = true;
	public static boolean SYMBOL_TABLE_OUTPUT = true;
	public static boolean CODE_GEN_OUTPUT = false;

	public ParseMain(Reader in)
	{
		// Construct the parser (generated by yacc)
		Parser yyparser = new Parser(in);

		// Invoke the parser
		int result = yyparser.yyparse();

		// Check results of parsing (and compiling)
		// result is 0 when no errors were encountered
		if (result == 0)
		{
			// Output for baseline scanning and parsing
			if (PARSE_OUTPUT)
			{
				System.out.println("\nParse successful");
			}

			// Output for symbol table
			if (SYMBOL_TABLE_OUTPUT)
			{
				System.out.println("\nSymbol Table Contents\n");
				System.out.println("===============================\n");
				System.out.println(yyparser.symtab);
			}
		}
		else
		{
			if (PARSE_OUTPUT)
			{
				System.out.println("\nParse errors\n");
			}
		}
	}

	public static void main(String[] args) throws IOException
	{
		Reader in;

		// Read from standard input unless there is a filename argument
		if (args.length == 0)
		{
			in = new InputStreamReader(System.in);
		}
		else
		{
			in = new FileReader(args[0]);
		}

		ParseMain parser = new ParseMain(in);
	}
}
