package com.siniak.finaltask.command;

public enum CommandEnum {
    LOGIN {
        {
            this.command = new LogInCommand();
        }
    },

    SIGN_UP {
        {
            this.command = new SignUpCommand();
        }
    },

    LOGOUT {
        {
            this.command = new LogOutCommand();
        }
    },

    CREATE_SEARCHED_PERSON {
        {
            this.command = new CreateSearchedPersonCommand();
        }
    },

    FIND_ALL_SEARCHED_PEOPLE {
        {
            this.command = new FindAllSearchedPeople();
        }
    },

    CHANGE_LANGUAGE {
        {
            this.command = new LanguageCommand();
        }
    },

    SHOW_PERSON_PAGE {
        {
            this.command = new ShowPersonPageCommand();
        }
    },

    EDIT_PERSON {
        {
            this.command = new EditPersonCommand();
        }
    },

    FIND_PERSON {
        {
            this.command = new FindSearchedPersonCommand();
        }
    },

    FIND_VOLUNTEERS {
        {
            this.command = new FindVolunteersCommand();
        }
    },

    SHOW_USER_PAGE {
        {
            this.command = new ShowUserPageCommand();
        }
    },

    SHOW_VOLUNTEER_PAGE {
        {
            this.command = new ShowVolunteerPageCommand();
        }
    },

    CREATE_HELP_RESPONSE {
        {
            this.command = new CreateHelpResponseCommand();
        }
    },

    DELETE_HELP_RESPONSE {
        {
            this.command = new DeleteHelpResponseCommand();
        }
    },

    UPDATE_HELP_RESPONSE {
        {
            this.command = new UpdateHelpResponseCommand();
        }
    },

    CREATE_VOLUNTEER {
        {
            this.command = new CreateVolunteerCommand();
        }
    },

    EDIT_VOLUNTEER {
        {
            this.command = new EditVolunteerCommand();
        }
    },

    UPDATE_VOLUNTEER {
        {
            this.command = new UpdateVolunteerCommand();
        }
    },

    UPDATE_SEARCHED_PERSON {
        {
            this.command = new UpdateSearchedPersonCommand();
        }
    },

    EDIT_USER{
        {
            this.command = new EditUserCommand();
        }
    },

    UPDATE_USER{
        {
            this.command = new UpdateUserCommand();
        }
    },

    DELETE_PERSON{
        {
            this.command = new DeleteSearchedPersonCommand();
        }
    },

    DELETE_VOLUNTEER{
        {
            this.command = new DeleteVolunteerCommand();
        }
    },

    EMPTY{
        {
            this.command = new EmptyCommand();
        }
    };

    Command command;

    public Command getCurrentCommand() {
        return command;
    }
}
