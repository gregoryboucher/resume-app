#!/bin/bash
# Based on script from less-rails-bootstrap
# Less::Rails is Copyright (c) 2011 Ken Collins, ken@metaskills.net and is distributed under the MIT license.

bootstrap_git='./frameworks/twitter_git'
webapp_dir='../src/main/webapp'
scala_app_dir='../src/main/scala/app'

base_js_dir="$scala_app_dir/javascript"
bootstrap_js_dir="$base_js_dir/twitter"
base_styles_dir="$scala_app_dir/less"
bootstrap_styles_dir="$base_styles_dir/_twitter"
bootstrap_font_dir="$webapp_dir/css/fonts/twitter"


error() {
echo -e -n "\033[1;31m$1"
echo -e '\033[0m'
}

success() {
echo -e -n "\033[1;32m$1"
echo -e '\033[0m'
}

info() {
echo -e -n "\033[1;34m$1"
echo -e '\033[0m'
}

if [ $# -ne 1 ] 
then
error "USAGE: $0 <bootstrap version>"
exit 1
fi

if [ ! -d $bootstrap_git ]; then
    info "Bootstrap not found. Cloning to $bootstrap_git..."
    git clone git://github.com/twbs/bootstrap.git $bootstrap_git
else
    info "Bootstrap found. Fetching to $bootstrap_git..."
    cd $bootstrap_git
    git fetch
    cd - > /dev/null
fi

cd $bootstrap_git
info "Using $1..."
git checkout $1
cd ../../
pwd

# Remove current twitter files
info "Remove $bootstrap_font_dir directory..."
rm -rf $bootstrap_font_dir

info "Remove $bootstrap_js_dir directory..."
rm -rf $bootstrap_js_dir
info "Remove $base_js_dir/bootstrap.jsm..."
rm -f $base_js_dir/bootstrap.jsm

info "Remove $bootstrap_styles_dir directory..."
rm -rf $bootstrap_styles_dir


info "Copying fonts to $bootstrap_font_dir..."
# fonts
mkdir -p $bootstrap_font_dir/
for f in $bootstrap_git/fonts/*; do
    bn=$(basename $f)
    cp $f $bootstrap_font_dir/$bn
done

info "Copying scripts tp $bootstrap_js_dir..."
# scripts
mkdir -p $bootstrap_js_dir/
for f in $bootstrap_git/js/*.js; do
    bn=$(basename $f)
    cp $f $bootstrap_js_dir/${bn/bootstrap-/}
done

info "Copying styles to $bootstrap_styles_dir..."
# styles
mkdir -p $bootstrap_styles_dir
for f in $bootstrap_git/less/*.less; do
    bn=$(basename $f)
    cp $f $bootstrap_styles_dir/$bn
done

[[ $(uname -s) == 'Darwin' ]] && ioption=(-i "") || ioption=(-i)
info "Sed to update fonts path in $bootstrap_styles_dir/variables.less..."
sed "${ioption[@]}" 's#^\(@icon-font-path:[[:space:]]*\"\).*\(\";\)#\1\.\.\/fonts\/twitter/\2#g' $bootstrap_styles_dir/variables.less
#info "Sed to update less path in $base_styles_dir/bootstrap.less.."
#sed "${ioption[@]}" 's#^\(@import \"\)\([a-z\-]*\.less\"\)#\1\_twitter\/\2#g' $base_styles_dir/bootstrap.less
#sed "${ioption[@]}" 's# url(# asset-url(#g' $lrb_fw_dir/*.less

info "Generate bootstrap.js..."
sed -n "s#.*'js/\([a-z]\{1,\}\.js\)'.*#twitter\/\1#p" $bootstrap_git/Gruntfile.js >> "$base_js_dir/bootstrap.jsm"

#info "Generate bootstrap.css.less..."
#mkdir -p $lrb_styles_dir
#echo "@import \"twitter/bootstrap/bootstrap\";" >> "$bootstrap_styles_dir/bootstrap.less"

success "Done"