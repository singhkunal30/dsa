package binary.tree;

public class Main {
	public static void main(String[] args) {
		TreeNode drinks = new TreeNode("Drinks");
		TreeNode hot = new TreeNode("hot");
		TreeNode cold = new TreeNode("cold");
		TreeNode tea = new TreeNode("tea");
		TreeNode coffee = new TreeNode("coffee");
		TreeNode beer = new TreeNode("beer");
		TreeNode coke = new TreeNode("coke");
		cold.addChildren(coke);
		cold.addChildren(beer);
		hot.addChildren(tea);
		hot.addChildren(coffee);
		drinks.addChildren(cold);
		drinks.addChildren(hot);
		System.out.println(drinks.print(0));
	}
}
