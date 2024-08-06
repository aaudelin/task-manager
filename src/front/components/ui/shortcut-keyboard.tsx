import * as React from "react";
import { cn } from "@/lib/utils";
import dynamic from "next/dynamic";

export interface ShortcutKeyboardProps
  extends React.HTMLAttributes<HTMLDivElement> {
  shortcut: string;
}

function ShortcutKeyboard({ className, shortcut }: ShortcutKeyboardProps) {
  const isMac = /(Mac|iPhone|iPod|iPad)/i.test(navigator.userAgent);

  return (
    <kbd
      className={cn(
        "hidden pointer-events-none lg:inline-flex h-5 select-none items-center gap-1 rounded border bg-muted px-1.5 font-mono text-[10px] font-medium text-muted-foreground opacity-100",
        className,
      )}
    >
      <span className={isMac ? "text-[1.20em]" : "text-[1em]"}>
        {isMac ? "⌘" : "Ctrl"}
      </span>
      {shortcut}
    </kbd>
  );
}

export default dynamic(() => Promise.resolve(ShortcutKeyboard), { ssr: false });
