| Class  | Member             | Method               | Scenario                     | Output     |
|--------|--------------------|----------------------|------------------------------|------------|
| Basket | List<Item> items   | add(String sku)      | Correct code basket not full | 1          | 
|        | int capacity       |                      | Correct code basket full     | 0          |
|        | static stdCapacity |                      | Incorrect code               | -1         |
|        | static Stock stock | remove(String sku)   | Exists                       | True       |
|        |                    |                      | Doesn't exist                | False      |
|        |                    | getTotalCost()       |                              | int        |
| Stock  | List<Item> stock   |                      |                              | void       |
|        |                    | getPrice(String sku) | Exists                       | int        |
|        |                    |                      | Doesn't exist                | -1         |
|        |                    | getFillings()        |                              | List<Item> |
|        |                    |                      |                              |            |
| Item   | String sku         |                      |                              |            |
|        | float price        |                      |                              |            |
|        | String name        |                      |                              |            |
|        | String variant     |                      |                              |            |
|        |                    |                      |                              |            |
|        |                    |                      |                              |            |
