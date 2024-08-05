import Link from "next/link";
import {
  InboxIcon,
  LucideProps,
  SquareCheckBigIcon,
  Target,
} from "lucide-react";

import { Badge } from "@/components/ui/badge";
import * as react from "react";
import { MenuDropdown } from "@/components/MenuDropdown";

interface Link {
  href: string;
  icon: react.ForwardRefExoticComponent<
    Omit<LucideProps, "ref"> & react.RefAttributes<SVGSVGElement>
  >;
  text: string;
  badge?: number;
}

const navLinks: Link[] = [
  {
    href: "inbox",
    icon: InboxIcon,
    text: "Inbox",
  },
  {
    href: "goals",
    icon: Target,
    text: "Goals",
  },
  {
    href: "tasks?expectedDate=today",
    icon: SquareCheckBigIcon,
    text: "Tasks",
    badge: 6,
  },
];

export function Navbar() {
  return (
    <div className="hidden border-r bg-muted/40 md:block">
      <div className="flex h-full max-h-screen flex-col gap-2">
        <div className="flex h-14 items-center border-b px-4 lg:h-[60px] lg:px-6">
          <MenuDropdown />
        </div>
        <div className="flex-1">
          <nav className="grid items-start px-2 text-sm font-medium lg:px-4">
            {navLinks.map((link) => (
              <Link
                key={link.href}
                href={link.href}
                className="flex items-center gap-3 rounded-lg px-3 py-2 text-muted-foreground transition-all hover:text-primary"
              >
                <link.icon className="h-4 w-4" />
                {link.text}
                {link.badge && (
                  <Badge className="ml-auto flex h-6 w-6 shrink-0 items-center justify-center rounded-full">
                    {link.badge}
                  </Badge>
                )}
              </Link>
            ))}
          </nav>
        </div>
      </div>
    </div>
  );
}

export function NavbarCollapsed() {
  return (
    <nav className="grid gap-1 text-sm font-medium">
      <MenuDropdown />
      {navLinks.map((link) => (
        <Link
          key={link.href}
          href={link.href}
          className="mx-[-0.65rem] flex items-center gap-4 rounded-xl px-3 py-1 text-muted-foreground hover:text-foreground"
        >
          <link.icon className="h-5 w-5" />
          {link.text}
          {link.badge && (
            <Badge className="ml-auto flex h-6 w-6 shrink-0 items-center justify-center rounded-full">
              {link.badge}
            </Badge>
          )}
        </Link>
      ))}
    </nav>
  );
}
