| Class         | Member             | Method                        | Scenario                     | Output     |
|---------------|--------------------|-------------------------------|------------------------------|------------|
| Basket        | List<Item> items   | add(String sku)               | Correct code basket not full | 1          | 
|               | int capacity       |                               | Correct code basket full     | 0          |
|               | static stdCapacity |                               | Incorrect code               | -1         |
|               | static Stock stock | remove(String sku)            | Exists                       | True       |
|               |                    |                               | Doesn't exist                | False      |
|               |                    | getTotalCost()                |                              | float      |
| Stock         | List<Item> stock   |                               |                              |            |
|               |                    | getPrice(String sku)          | Exists                       | int        |
|               |                    |                               | Doesn't exist                | -1         |
|               |                    | getFillings()                 |                              | List<Item> |
|               |                    | getItem(String sku)           | Exists                       | Item       |
|               |                    |                               | Does not exist               | null       |
| Abstract Item | String sku         | getSku()                      |                              | sku        |
|               | float price        | getPrice()                    |                              | price      |
|               | String name        | getName()                     |                              | name       |
|               | String variant     | getVariant()                  |                              | variant    |
|               |                    |                               |                              |            |
| Bagel         | List<Filling>      | addFilling(Filling filling)   |                              | void       |
|               |                    | removeFilling(String variant) | Filling exists in list       | true       |
| Coffee        |                    |                               | Filling does not exist       | false      |
| Filling       |                    |                               |                              |            |


