@objects
    header-section                          id                      header
    menu-section                            id                      menu
    middle-wrapper-section                  xpath                   //div[@id='middle']/div[@class='middle-wrapper']


@on desktop
= Welcome Page Validation =
    = Header Section =
        header-section:
            above menu-section
            above middle-wrapper-section

    = Menu Section =
        menu-section:
            below header-section
            above middle-wrapper-section -2 to 2px

    = Middle Wrapper Section =
        middle-wrapper-section:
            below header-section
            below menu-section -2 to 2px
