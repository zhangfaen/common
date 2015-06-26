# If not running interactively, don't do anything
[ -z "$PS1" ] && return

# don't put duplicate lines in the history. See bash(1) for more options
# ... or force ignoredups and ignorespace
HISTCONTROL=ignoredups:ignorespace

# append to the history file, don't overwrite it
shopt -s histappend

# uncomment for a colored prompt, if the terminal has the capability; turned
# off by default to not distract the user: the focus in a terminal window
# should be on the output of commands, not on the prompt
force_color_prompt=yes

if [ -n "$force_color_prompt" ]; then
    if [ -x /usr/bin/tput ] && tput setaf 1 >&/dev/null; then
	# We have color support; assume it's compliant with Ecma-48
	# (ISO/IEC-6429). (Lack of such support is extremely rare, and such
	# a case would tend to support setf rather than setaf.)
	color_prompt=yes
    else
	color_prompt=
    fi
fi

if [ "$color_prompt" = yes ]; then
    PS1='${debian_chroot:+($debian_chroot)}\[\033[01;32m\]\u@\h\[\033[00m\]:\[\033[01;34m\]\w\[\033[00m\]\$ '
else
    PS1='${debian_chroot:+($debian_chroot)}\u@\h:\w\$ '
fi
unset color_prompt force_color_prompt

# enable color support of ls and also add handy aliases
if [ -x /usr/bin/dircolors ]; then
    test -r ~/.dircolors && eval "$(dircolors -b ~/.dircolors)" || eval "$(dircolors -b)"
    # WARNING: enabling this can cause multi-second delays due to NFS latency
    alias ls='ls --color=auto'
    alias dir='dir --color=auto'
    alias vdir='vdir --color=auto'

    alias grep='grep --color=auto'
    alias fgrep='fgrep --color=auto'
    alias egrep='egrep --color=auto'
fi

# some more ls aliases
alias ll='ls -alF'
alias la='ls -A'
alias l='ls -CF'

alias .='cd ..'
alias ..='cd ..; cd ..'
alias ...='cd ..; cd ..; cd ..'
alias ....='cd ..; cd ..; cd ..; cd ..'
alias .....='cd ..; cd..; cd ..; cd ..; cd ..'

export  PS1='\n\[\033[00;35m\][\w]\n\[\033[00;35m\]\u\[\033[00m\]@\[\033[00;35m\]\h\[\033[00m\]\$'

function gf() {
  grep --include="$2" "$1" . -rin  
}

function gfs() {
  grep --include="*"$2"" "$1" . -rin  
}

function fn() {
  find . -iname "$@";
}

alias ht='history'export PATH=/usr/local/git/bin:/usr/local/bin:/usr/local/sbin:/usr/local/bin:/usr/bin:/bin:/usr/local/sbin:/usr/sbin:/sbin:/usr/local/bin/g4bin:/usr/local/git/bin:/usr/local/go/bin
export PATH=/usr/local/git/bin:/usr/local/bin:/usr/local/sbin:$PATH
export M2_HOME=/Users/zhangfaen/dev/apache-maven-3.2.3
export M2=$M2_HOME/bin
export MAVEN_OPTS="-Xms256m -Xmx512m"
export PATH=$M2:$PATH
