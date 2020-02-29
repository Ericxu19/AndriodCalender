Hello friends,

notable things:

- using serialization seems good but we need to all agree on a universal read/write environment, I suggest ObjectOutputStream, FileOutputStream, etc. as done in the sample
- we need to agree on the same implementation for time as well, and i suggest LocalDateTime, which i used
- pushes with .idea or .iml files are rejected by remote, so i'm just using command line right now so i avoid generating those files through IntelliJ
- in order for code to run, your working directory needs to be at the Calendar file level because of path names (please tell the group if there's a better way)
