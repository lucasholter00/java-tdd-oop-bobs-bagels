| Module | Class            | Member             | Method                        | Scenario                     | Output     |
|--------|------------------|--------------------|-------------------------------|------------------------------|------------|
| Core   | Basket           | List<Item> items   | add(String sku)               | Correct code basket not full | 1          | 
|        |                  | int capacity       |                               | Correct code basket full     | 0          |
|        |                  | static stdCapacity |                               | Incorrect code               | -1         |
|        |                  | static Stock stock | remove(String sku)            | Exists                       | True       |
|        |                  |                    |                               | Doesn't exist                | False      |
|        |                  |                    | getTotalCost()                |                              | float      |
|        | Stock            | List<Item> stock   |                               |                              |            |
|        |                  |                    | getPrice(String sku)          | Exists                       | price      |
|        |                  |                    |                               | Doesn't exist                | -1         |
|        |                  |                    | getFillings()                 |                              | List<Item> |
|        |                  |                    | getItem(String sku)           | Exists                       | Item       |
|        |                  |                    |                               | Does not exist               | null       |
|        | Abstract Item    | String sku         | getSku()                      |                              | sku        |
|        |                  | float price        | getPrice()                    |                              | price      |
|        |                  | String name        | getName()                     |                              | name       |
|        |                  | String variant     | getVariant()                  |                              | variant    |
|        |                  |                    |                               |                              |            |
|        | Bagel            | List<Filling>      | addFilling(Filling filling)   |                              | void       |
|        |                  |                    | removeFilling(String variant) | Filling exists in list       | true       |
|        | Coffee           |                    |                               | Filling does not exist       | false      |
|        | Filling          |                    |                               |                              |            |
|        |                  |                    |                               |                              |            |
Extension 1:
 As a user I want to take part of the special offers so that I can save money.

| Module | Class         | Member             | Method                        | Scenario                     | Output        |
|--------|---------------|--------------------|-------------------------------|------------------------------|---------------|
| Core   | Basket        | List<Item> items   | add(String sku)               | Correct code basket not full | 1             |
|        |               | int capacity       |                               | Correct code basket full     | 0             |
|        |               | static stdCapacity |                               | Incorrect code               | -1            |
|        |               | static Stock stock | remove(String sku)            | Exists                       | True          |
|        |               |                    |                               | Doesn't exist                | False         |
|        |               |                    | getTotalCost()                |                              | float         |
|        |               |                    | getDiscountetCost()           |                              |               |
|        | Stock         | List<Item> stock   |                               |                              |               |
|        |               |                    | getPrice(String sku)          | Exists                       | price         |
|        |               |                    |                               | Doesn't exist                | -1            |
|        |               |                    | getFillings()                 |                              | List<Item>    |
|        |               |                    | getItem(String sku)           | Exists                       | Item          |
|        |               |                    |                               | Does not exist               | null          |
|        | Abstract Item | String sku         | getSku()                      |                              | sku           |
|        |               | float price        | getPrice()                    |                              | price         |
|        |               | String name        | getName()                     |                              | name          |
|        |               | String variant     | getVariant()                  |                              | variant       |
|        |               |                    |                               |                              |               |
|        | Bagel         | List<Filling>      | addFilling(Filling filling)   |                              | void          |
|        |               |                    | removeFilling(String variant) | Filling exists in list       | true          |
|        |               |                    |                               | Filling does not exist       | false         |
|        |               |                    | getFillings()                 |                              | List<Filling> |
|        | Coffee        |                    |                               |                              |               |
|        | Filling       |                    |                               |                              |               |
|        |               |                    |                               |                              |               |

Extension 2:
As a user I want to get a reciept with my order so that I can know what I have bought.

| Module | Class         | Member             | Method                        | Scenario                     | Output          |
|--------|---------------|--------------------|-------------------------------|------------------------------|-----------------|
| Core   | Basket        | List<Item> items   | add(String sku)               | Correct code basket not full | 1               |
|        |               | int capacity       |                               | Correct code basket full     | 0               |
|        |               | static stdCapacity |                               | Incorrect code               | -1              |
|        |               | static Stock stock | remove(String sku)            | Exists                       | True            |
|        |               |                    |                               | Doesn't exist                | False           |
|        |               |                    | getTotalCost()                |                              | float           |
|        |               |                    | getDiscountetCost()           |                              |                 |
|        |               |                    | getPriceInfo()                |                              | List<PriceInfo> |
|        | Stock         | List<Item> stock   |                               |                              |                 |
|        |               |                    | getPrice(String sku)          | Exists                       | price           |
|        |               |                    |                               | Doesn't exist                | -1              |
|        |               |                    | getFillings()                 |                              | List<Item>      |
|        |               |                    | getItem(String sku)           | Exists                       | Item            |
|        |               |                    |                               | Does not exist               | null            |
|        | Abstract Item | String sku         | getSku()                      |                              | sku             |
|        |               | float price        | getPrice()                    |                              | price           |
|        |               | String name        | getName()                     |                              | name            |
|        |               | String variant     | getVariant()                  |                              | variant         |
|        |               |                    |                               |                              |                 |
|        | Bagel         | List<Filling>      | addFilling(Filling filling)   |                              | void            |
|        |               |                    | removeFilling(String variant) | Filling exists in list       | true            |
|        |               |                    |                               | Filling does not exist       | false           |
|        |               |                    | getFillings()                 |                              | List<Filling>   |
|        | Coffee        |                    |                               |                              |                 |
|        | Filling       |                    |                               |                              |                 |
|        |               |                    |                               |                              |                 |
|        | Reciept       | Basket basket      | getReciept()                  |                              | String          |
|        |               |                    |                               |                              |                 |
|        | PriceInfo     | String name        |                               |                              |                 |
|        |               | float cost         |                               |                              |                 |
|        |               | float discount     |                               |                              |                 |
|        |               | int count          |                               |                              |                 |

Extension 3:
As a user I want to get a reciept with my order and discounts so that I can know what I have bought andhow much I have saved.

| Module | Class         | Member             | Method                        | Scenario                     | Output          |
|--------|---------------|--------------------|-------------------------------|------------------------------|-----------------|
| Core   | Basket        | List<Item> items   | add(String sku)               | Correct code basket not full | 1               |
|        |               | int capacity       |                               | Correct code basket full     | 0               |
|        |               | static stdCapacity |                               | Incorrect code               | -1              |
|        |               | static Stock stock | remove(String sku)            | Exists                       | True            |
|        |               |                    |                               | Doesn't exist                | False           |
|        |               |                    | getTotalCost()                |                              | float           |
|        |               |                    | getDiscountetCost()           |                              |                 |
|        |               |                    | getPriceInfo()                |                              | List<PriceInfo> |
|        | Stock         | List<Item> stock   |                               |                              |                 |
|        |               |                    | getPrice(String sku)          | Exists                       | price           |
|        |               |                    |                               | Doesn't exist                | -1              |
|        |               |                    | getFillings()                 |                              | List<Item>      |
|        |               |                    | getItem(String sku)           | Exists                       | Item            |
|        |               |                    |                               | Does not exist               | null            |
|        | Abstract Item | String sku         | getSku()                      |                              | sku             |
|        |               | float price        | getPrice()                    |                              | price           |
|        |               | String name        | getName()                     |                              | name            |
|        |               | String variant     | getVariant()                  |                              | variant         |
|        |               |                    |                               |                              |                 |
|        | Bagel         | List<Filling>      | addFilling(Filling filling)   |                              | void            |
|        |               |                    | removeFilling(String variant) | Filling exists in list       | true            |
|        |               |                    |                               | Filling does not exist       | false           |
|        |               |                    | getFillings()                 |                              | List<Filling>   |
|        | Coffee        |                    |                               |                              |                 |
|        | Filling       |                    |                               |                              |                 |
|        |               |                    |                               |                              |                 |
|        | Reciept       | Basket basket      | getReciept()                  |                              | String          |
|        |               |                    | getDiscountedReciept()        |                              | String          |
|        | PriceInfo     | String name        |                               |                              |                 |
|        |               | float cost         |                               |                              |                 |
|        |               | float discount     |                               |                              |                 |
|        |               | int count          |                               |                              |                 |

