package seleniumPack;

public class XpathAndCss {
	
	public static void main(String[] args) {
		
		// Absolute Xpath - html/body/div[1]/h1
				// Relative Xpath - html//h1 or //h1

				// / - child only
				// // - child and grant-child

				// parent::tagname - child to parent - //h1/parent::div
				// ancestor::tagname - child to grant-parent - //h1/ancestor::html or //div[@id='right_col_top']/ancestor::div

				// following-sibling::tagname -
				// //option[text()='Second Option']/following-sibling::option
				// preceding-sigling::tagname -
				// //option[text()='Second Option']/preceding-sibling::option

				// text() - based on visible text //option[text()='Second Option']
				// starts-with - matching starting content - //option[starts-with(text(),'Second ')]
				// contains - matching content anywhere - //option[contains(text(),'cond ')]

		// CSS Selector
				// Unable to achive parent, ancestor, preceding-siblings and text match
				// scenarios
				// > - child only
				// ' ' - child and grand child
				// # - by ID -> #q7
				// . - by classname -> .samples
				// tag[att=val] - single attribute
				// tag[att=val][att2=val2] - multiple attribute -> input[name='subject'][size='20']
				// tag[att^=val] - starts with -> input[name^='sub']
				// tag[att$=val] - ends with -> input[name$='ject']
				// tag[att*=val] - contains -> input[name*='ject']

		
	}

}
