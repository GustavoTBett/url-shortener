git filter-branch --commit-filter '
    if [ "$GIT_AUTHOR_NAME" = "gustavoTBett" ];
    then
        GIT_AUTHOR_NAME="GustavoTBett";
        GIT_COMMITTER_NAME="GustavoTBett";
        GIT_AUTHOR_EMAIL="gustavotaufembachbtt@gmail.com";
        GIT_COMMITTER_EMAIL="gustavotaufembachbtt@gmail.com";
        git commit-tree "$@";
    else
        git commit-tree "$@";
    fi' HEAD