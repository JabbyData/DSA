-> **special kind of a growable array that allows us to add or remove an element from both sides**
- It’s not thread-safe
- Null elements are not accepted
- Works significantly faster than the synchronized _Stack_
- It is a faster queue than _LinkedList_ due to the better locality of reference
- Most operations have amortized constant time complexity
- An _Iterator_ returned by an _ArrayDeque_ is fail-fast
- _ArrayDeque_ automatically doubles the size of an array when the head and tail pointer meets each other while adding an element