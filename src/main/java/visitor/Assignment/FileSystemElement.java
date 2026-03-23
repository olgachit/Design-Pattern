package visitor.Assignment;

public interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}