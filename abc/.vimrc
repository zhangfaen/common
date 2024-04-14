" Enable line numbers
set number

" Highlight search results as you type
set incsearch

" Highlight all matches
set hlsearch

" Ignore case when searching
set ignorecase

" Override ignorecase if search includes uppercase letters
set smartcase

" Enable mouse mode
set mouse=a

" Enable line wrapping
set wrap

" Show a matching parenthesis or bracket
set showmatch

" Improve command line completion
set wildmenu

" Set the status line
set statusline=%F%m%r%h%w\ [%L]\ [%p%%]\ [%c]
set laststatus=2

" Set the tab size to 4 spaces
set tabstop=4
set shiftwidth=4
set expandtab


" This configuration will:

" Display line numbers on the left side of the editor.
" Highlight search patterns incrementally as you type them.
" Highlight all matches for the last searched pattern.
" Ignore case in search patterns unless there's an uppercase letter, in which case it's case-sensitive (thanks to smartcase).
" Enable the mouse for easier window and text selection.
" Show matching parentheses or brackets as you type.
" Provide a richer command line completion experience.
" Define a custom status line that shows the file name, modification flags, line count, percentage through the file, and current line number.
" Convert tabs to spaces and set indentation to 4 spaces, which is a common style for readability.
" To use this configuration:

" Open a terminal.
" Type vim ~/.vimrc to open or create your Vim configuration file.
" Paste the contents of the above configuration into the file.
" Save and close the file by typing :wq in Vim.
