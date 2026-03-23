package visitor.Assignment;

public class Main {
    public static void main(String[] args) {

        File file1 = new File("document.txt", 2.5);
        File file2 = new File("photo.jpg", 5.0);
        File file3 = new File("notes.txt", 1.2);
        Directory root = new Directory("root");
        Directory subDir = new Directory("sub");

        subDir.addElement(file3);
        root.addElement(file1);
        root.addElement(file2);
        root.addElement(subDir);

        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total Size: " + sizeVisitor.getTotalSize() + " MB");

        SearchVisitor searchVisitor = new SearchVisitor(".txt");
        root.accept(searchVisitor);
        System.out.println("Found files:");
        for (File file : searchVisitor.getFoundFiles()) {
            System.out.println(file.getName());
        }
    }
}
