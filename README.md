# TomatoClock-and-PlannedWeek
An application software based on Android platform.<br>
Written in Java.<br>
Development tools: `Android Studio` `PowerDesigner`
## Development team
Zhuocun Zhai, Zhenglong Wang, Chenyi Wang, Weiteng Li<br>
School of Cyber Security, Shanghai Jiao Tong University
## Main ideas
* Pomodoro Technique
* Focus Matrix
## User Group
Anyone who has the demand of improving work efficiency and staying focused.
## Summary
This project is intended to develop a software with transaction management and tomato-based work method.<br>

In the Pomodoro module, the software will follow the Pomodoro to help the user focus on the current transaction. In the `25-minute working period`, the interface displays the remaining working time, and according to the needs, the user can add statements and pictures to stimulate. The software will give a reminder signal when the user uses the mobile phone. When the working segment ends, the software will inform the user of the need `Take a break for 5 minutes`. Running a cycle in this mode, the user will harvest a "tomato" and add it to the corresponding transaction, otherwise the user will not receive the grain. On this basis, the additional task of this project is to provide white noise service to help users resist external interference and improve work efficiency.<br>

In the transaction management module, the user can add multiple transactions that need to be completed. By inputting the transaction name and the expiration date, the software can generate the most basic task. If the user only uses the Pomodoro module, "tomato" is automatically added to "Default" in the task. On this basis, the software provides two criteria: "emergency" and "important". By clicking the icon, the user can make a score judgment on whether the current task is urgent and whether the current task is important for the added transaction. The software will properly prioritize the current transaction based on these two scoring metrics. When the user does not enter these two scoring items, the default value is 0. At the same time, the software will design an algorithm to calculate the deadline for the transaction and the current number of "tomato". When the user's time investment is significantly less than the required time of the transaction, the software will remind the user and provide the recommended investment time.<br>

The additional task of this project is to be able to provide a chart page to reflect the user's investment time for each added transaction on the same day, to help users more intuitively observe their time management status.