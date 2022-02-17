package com.example.quizapp
object Constants{
    const val  User_Name:String="User_Name"
    const val Total_Question:String="Total_Questions"
    const val Correct_Answer:String="Correct Answer"
    fun getconstans():ArrayList<Questions>{
        val questionlist=ArrayList<Questions>()
        val question1=Questions(1,
            "What is the default behavior of Kotlin classes?",

            "All classes are sealed",
            "All classes are public",
            "All classes are abstract",
            "All classes are final",
            4)
        questionlist.add(question1)
        val question2=Questions(2,
            "Which of the following is true for Kotlin variables?",

            "var can't be changed",
            "val corresponds to final variable in Java",
            "val can be changed",
            "All variables are immutable by default",
            2)
        questionlist.add(question2)
        val question3=Questions(3,
            "What is an immutable variable?",

            " A variable that can't change, read-only",
            "A variable that can be changed",
            "A variable used for string interpolation",
            "None of the above",
            1)
        questionlist.add(question3)
        val question4=Questions(4,
            "Which of follwing targets currently not supported by Kotlin?",

            ".NET CLR",
            "LLVM",
            "Javascript",
            "None of the above",
            1)
        questionlist.add(question4)
        val question5=Questions(5,
            "How do you get the length of a string in Kotlin?",

            "str.lengthOf",
            "str.length",
            "str.lengthOf",
            "None of these",
            2)
        questionlist.add(question5)
        val question6=Questions(6,
            "Which file extension is used to save Kotlin files?",

            ".kot",
            ".java",
            ".andriod",
            ".kt or .kts",
            4)
        questionlist.add(question6)
        val question7=Questions(7,
            "An activity can be thought of as corresponding to what?",

            "A Java class",
            "A Java project",
            "A method call",
            "An object field",
            1)
        questionlist.add(question7)
        val question8=Questions(8,
            "Which of these is used to handle null exceptions in kotlin?",

            "Range",
            "Sealed Class",
            "Elvis Operator",
            "Lambda function",
            3)
        questionlist.add(question8)
        val question9=Questions(9,
            "Which of the following is not a Java features?",

            "Dynamic",
            "Architecture Neutral",
            "Use of pointers",
            "Object-oriented",
            3)
        questionlist.add(question9)
        val question10=Questions(10,
            "_____ is used to find and fix bugs in the Java programs.",

            "JVM",
            "JRE",
            "JDK",
            "JDB",
            4)
        questionlist.add(question10)


        return questionlist

    }
}
