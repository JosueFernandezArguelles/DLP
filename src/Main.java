
import ast.errorhandler.ErrorHandler;
import ast.program.Program;
import codegeneration.CodeGenerator;
import codegeneration.ExecuteCGVisitor;
import codegeneration.OffsetVisitor;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorView;
import parser.*;

import org.antlr.v4.runtime.*;
import semantic.visitor.IdentificationVisitor;
import semantic.visitor.TypeCheckingVisitor;

public class Main {
	
	public static void main(String... args) throws Exception {
		   if (args.length<1) {
		        System.err.println("Please, pass me the input file.");
		        return;
		    }
		   		 			
		 // create a lexer that feeds off of input CharStream
		CharStream input = CharStreams.fromFileName(args[0]);
		CmmLexer lexer = new CmmLexer(input);

		// create a parser that feeds off the tokens buffer
		CommonTokenStream tokens = new CommonTokenStream(lexer); 
		CmmParser parser = new CmmParser(tokens);
		Program ast = parser.program().ast;

		IdentificationVisitor identificationVisitor = new IdentificationVisitor();
		identificationVisitor.visit(ast, null);

		TypeCheckingVisitor tcVisitor = new TypeCheckingVisitor();

		tcVisitor.visit(ast, null);

		OffsetVisitor offsetVisitor = new OffsetVisitor();

		offsetVisitor.visit(ast, null);

		CodeGenerator cg = new CodeGenerator(args[1]);

		ExecuteCGVisitor executeCGVisitor = new ExecuteCGVisitor(cg);

		executeCGVisitor.visit(ast, null);

		cg.write();

		if(ErrorHandler.anyErrors()){
			ErrorHandler.showErrors(System.err);
		} else{
			IntrospectorModel model=new IntrospectorModel("Program", ast);
			new IntrospectorView("Introspector", model);
		}
	}
}