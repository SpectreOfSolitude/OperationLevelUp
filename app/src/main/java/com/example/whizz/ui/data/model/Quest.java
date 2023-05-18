package com.example.whizz.ui.data.model;

public class Quest
{
    private String QuestTitle;
    private String Description;

    public Quest(String QuestTitle, String Description)
    {
        this.QuestTitle = QuestTitle;
                this.Description = Description;
    }

    public void SetQuestTitle( String NewQuest)
    {
        this.QuestTitle = NewQuest;
    }

    public String GetQuestTitle()
    {
        return QuestTitle;
    }

    public void SetDescription(String NewDescription)
    {
        this.Description = NewDescription;
    }

    public String GetDescription()
    {
        return Description;
    }
}
