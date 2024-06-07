# Sorting Visualization Project

## Introduction
Welcome to the Sorting Visualization Project! This project is a graphical representation of basic sorting algorithms, designed to help users understand and visualize how different sorting techniques work. Developed by Group 2 for the Object-Oriented Programming (OOP) course in the 2023.1 semester at the Hanoi University of Science and Technology, this project aims to provide an educational tool for students and enthusiasts alike.
## Demo [Please give me a Star in Github if you think this project is usefuls]

[https://github.com/duongnguyen291/SortingDemonstrate/blob/master/Presentation/Demo.mp4](https://github.com/duongnguyen291/SortingDemonstrate/assets/116486270/8aa2850a-6f0f-40cb-9b95-97336da3191c)

## Features
- **Visual Representation**: Watch as the sorting algorithms dynamically sort arrays of numbers.
- **Algorithms Included**:
  - Bubble Sort
  - Selection Sort
  - Insertion Sort
  - Merge Sort
  - Quick Sort
  - Shell Sort
  - Radix Sort
- **User Interaction**: Control the speed of the visualization and select different algorithms to see their behavior in real-time.
- **AI Assistant**: Question and answers with AI Assisstant all the problems relate sorting problems.
- **Educational Tool**: Ideal for students learning about sorting algorithms and their performance.

## Technologies Used
- **Programming Language**: Java
- **Development Environment**: Visual Studio Code or IntelliJ IDEA (or any Java-supported IDE)
- **Libraries**: Swing, awt, stringworker for graphical user interface and many orther.

## Installation and Setup
1. **Clone the Repository**: 
    ```sh
    git clone https://github.com/duongnguyen291/SortingDemonstrate
    ```
2. **Navigate to the Project Directory**:
    ```sh
    cd SortingDemonstrate
    ```
3. **Open the Project in Your IDE**:
    - Open IntelliJ IDEA (or your preferred Java IDE).
    - Installing java package needed

4. **Build the Project**: 
    - Ensure all dependencies are installed.
    - Build the project using your IDE's build tools.

5. **Run the Application**:
    - Locate the main class file `App.java`.
    - Run the application to start the visualization.

## Usage
- **Select Algorithm**: Choose from the dropdown menu to select a sorting algorithm.
- **Spawn Capacity**: Type the number elements of array.
- **Adjust Speed**: Use the slider to control the speed of the visualization.
- **Pause/Continue**: Click the 'pause' button to stop the visualization and 'Continue' to continue it.

## Contributors
- **Team Members**:
  - Member 1: Nguyễn Đình Dương
  - Member 2: Nguyễn Lan Nhi
  - Member 3: Nguyễn Mỹ Duyên
  - Member 4: Hồ Bảo Thư
  - Member 5: Hà Việt Khánh
  - Member 6: Nguyễn Trọng Minh Phương

This project is a collaborative effort by Group 2, as part of the coursework for the Object-Oriented Programming course at the Hanoi University of Science and Technology.
# Folder structure:
```
SortingDemonstrate
├── .idea/
├── Design/Usecase.pdf and classDiagram.pdf
├── Presentation/
├── src/
│   ├── OOP/
│   │   ├── Group2/
│   │   │   ├── Visualizer/
│   │   │   │   ├── graphicsElements/
│   │   │   │   │   ├── animation/sort/sorter.java
│   │   │   │   │   ├── background/
│   │   │   │   │   ├── bars/bars.java
│   │   │   │   │   ├── button/buttonFrame/buttonPanel.java
│   │   │   │   │   ├── canvas/myCanvas.java
│   │   │   │   │   ├── color/colorConcept.java
│   │   │   │   │   ├── helping/
│   │   │   │   │   ├── myFormatter/myFormatter.java
│   │   │   │   │   ├── env.java
│   │   │   │   ├── screen/
│   │   │   │   │   ├── menu/
│   │   │   │   │   │   ├── ChatBox.java
│   │   │   │   │   │   ├── menuHelping.java
│   │   │   │   │   │   ├── menuSortingBasic.java
│   │   │   │   │   │   ├── VirtualAssisstant.java
│   │   │   │   │   ├── mainMenu.java
│   │   │   │   ├── sorting/
│   │   │   │   │   ├── BubbleSort.java
│   │   │   │   │   ├── CountingSort.java
│   │   │   │   │   ├── MergeSort.java
│   │   │   │   │   ├── QuickSort.java
│   │   │   │   │   ├── RadixSort.java
│   │   │   │   │   ├── SelectionSort.java
│   │   │   │   │   ├── ShellSort.java
│   │   │   │   │   ├── Sort.java
├── .gitignore
├── LICENSE
├── README.md
├── SortingDemonstrate.iml

```


## Assignment of members

### 1. Nguyễn Đình Dương - 20225966 (Leader)

- Package [`Visualizer/graphicsElements/animation/sorter/sorter.java`](https://github.com/duongnguyen291/SortingDemonstrate/blob/master/src/OOP/Group2/Visualizer/graphicsElements/animation/sorter/sorter.java)
- Project manager
### 2. Nguyễn Lan Nhi - 20225991
- Package [`Visualizer/screen/menu/menuHelping.java`](https://github.com/duongnguyen291/SortingDemonstrate/blob/master/src/OOP/Group2/Visualizer/screen/menu/menuHelping.java)
- Package [`Visualizer/screen/menu/menuSortingBasic.java`](https://github.com/duongnguyen291/SortingDemonstrate/blob/master/src/OOP/Group2/Visualizer/screen/menu/menuSortingBasic.java)
- Package [`Visualizer/screen/mainMenu.java`](https://github.com/duongnguyen291/SortingDemonstrate/blob/master/src/OOP/Group2/Visualizer/screen/mainMenu.java)
- Package [`Visualizer\graphicsElements\helping`](D:\github\SortingDemonstrate\src\OOP\Group2\Visualizer\graphicsElements\helping)
- Package [`Visualizer\graphicsElements\button\buttonImag`](D:\github\SortingDemonstrate\src\OOP\Group2\Visualizer\graphicsElements\button\buttonImage)
- Slide Presentation
### 3. Nguyễn Mỹ Duyên - 20225967
- UseCase Diagram
- Class Diagram
- Package [`Visualizer/screen/menu/ChatBox.java`](https://github.com/duongnguyen291/SortingDemonstrate/blob/master/src/OOP/Group2/Visualizer/screen/menu/ChatBox.java)
- Package [`Visualizer/screen/menu/VirtualAssisstant.java`](https://github.com/duongnguyen291/SortingDemonstrate/blob/master/src/OOP/Group2/Visualizer/screen/menu/VirtualAssisstant.java)
- Slide Presentation
### 4. Hồ Bảo Thư - 20226003 
- Package [`Visualizer/graphicsElements/background`](https://github.com/duongnguyen291/SortingDemonstrate/tree/master/src/OOP/Group2/Visualizer/graphicsElements/background)
- Package [`Visualizer/graphicsElements/bars/bars.java`](https://github.com/duongnguyen291/SortingDemonstrate/blob/master/src/OOP/Group2/Visualizer/graphicsElements/bars/bars.java)
- Package [`Visualizer/graphicsElements/canvas/myCanvas.java`](https://github.com/duongnguyen291/SortingDemonstrate/blob/master/src/OOP/Group2/Visualizer/graphicsElements/canvas/myCanvas.java)
- Package [`Visualizer/graphicsElements/color/colorConcept.java`](https://github.com/duongnguyen291/SortingDemonstrate/blob/master/src/OOP/Group2/Visualizer/graphicsElements/color/colorConcept.java)
- Package [`Visualizer/graphicsElements/myFormatter/myFormatter.java`](https://github.com/duongnguyen291/SortingDemonstrate/blob/master/src/OOP/Group2/Visualizer/graphicsElements/myFormatter/myFormatter.java)
- Slide Presentation
### 5. Hà Việt Khánh - 20225979
- Package [`Visualizer/sorting/RadixSort.java`](https://github.com/duongnguyen291/SortingDemonstrate/blob/master/src/OOP/Group2/Visualizer/sorting/RadixSort.java)
- Package [`Visualizer/sorting/BubbleSort.java`](https://github.com/duongnguyen291/SortingDemonstrate/blob/master/src/OOP/Group2/Visualizer/sorting/BubbleSort.java)
- Package [`Visualizer/sorting/CountingSort.java`](https://github.com/duongnguyen291/SortingDemonstrate/blob/master/src/OOP/Group2/Visualizer/sorting/CountingSort.java)
- Package [`Visualizer/sorting/QuickSort.java`](https://github.com/duongnguyen291/SortingDemonstrate/blob/master/src/OOP/Group2/Visualizer/sorting/QuickSort.java)

### 6. Nguyễn Trọng Minh Phương - 20225992
- Package [`Visualizer/sorting/Sort.java`](https://github.com/duongnguyen291/SortingDemonstrate/blob/master/src/OOP/Group2/Visualizer/sorting/Sort.java)
- Package [`Visualizer/sorting/MergeSort.java`](https://github.com/duongnguyen291/SortingDemonstrate/blob/master/src/OOP/Group2/Visualizer/sorting/MergeSort.java)
- Package [`Visualizer/sorting/SelectionSort.java`](https://github.com/duongnguyen291/SortingDemonstrate/blob/master/src/OOP/Group2/Visualizer/sorting/SelectionSort.java)
- Package [`Visualizer/sorting/ShellSort.java`](https://github.com/duongnguyen291/SortingDemonstrate/blob/master/src/OOP/Group2/Visualizer/sorting/ShellSort.java)


## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

## Acknowledgements
- Our professor and course instructor for their guidance and support.
- The open-source community for providing useful libraries and tools.

## Contact
For any questions or feedback, please contact:
- Email: duong.nd225966@sis.hust.edu.vn
- GitHub: [https://github.com/duongnguyen291/SortingDemonstrate](https://github.com/duongnguyen291/SortingDemonstrate)

Thank you for using the Sorting Visualization Project! We hope it enhances your understanding of sorting algorithms.
