package test.wu.tinyioc.bean.factory;

public class HelloWorldService {
	private String text;

    private OutputService outputService;

    public void helloWorld(){
         //outputService.output(text);
    	System.out.println("china is ok!");
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setOutputService(OutputService outputService) {
        this.outputService = outputService;
    }
}
